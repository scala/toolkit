#!/usr/bin/env -S scala-cli shebang
//> using scala 3.3
//> using toolkit 0.1.7
//> using dep io.get-coursier:coursier_2.13:2.1.4
//> using file Dependencies.scala
//> using file Config.scala

import upickle.default.*
import Dependencies.*
import coursier.*
import coursier.given
import coursier.graph.DependencyTree

Utility.requireCmd("scala-cli")

val (version, toolkitFile, overwrite) = args match
    case Array(VersionString(version), toolkitFile) => (version, toolkitFile, false)
    case Array(VersionString(version), toolkitFile, "--overwrite") => (version, toolkitFile, true)
    case _ => throw new Exception("Usage: ./scripts/savetree.sc <version> <toolkitfile> [--overwrite]])")

println("Publishing locally to validate the dependency tree...")
os.proc("scala-cli", "--power", "publish", "local", "--cross", "--organization", Config.organization, "--version", version.toString, toolkitFile).call()

Config.crossVersions.foreach(saveTree)

def saveTree(crossVersion: String): Unit = 
    val file = os.pwd / "scripts" / "expected" / s"deptree_${crossVersion}.json"
    require(!os.exists(file) || overwrite, s"File $file already exists. Use --overwrite to overwrite it.")

    val resolution = Resolve()
        .addDependencies(Dependency(Module(Organization(Config.organization), ModuleName(Config.name + "_" + crossVersion)), version.toString))
        .run()
    
    val head = DependencyTree(resolution).head
    val depTree = makeDepTree(head)
    val snapshot = DepsSnapshot(depTree.id, version, depTree.deps)

    os.write.over(file, write(snapshot, 2), createFolders = true)
