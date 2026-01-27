# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_3:0.8.0` from `0.8.0` to `0.8.1` under `org.scala-lang:toolkit-test_3:0.8.1`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-lib_3:0.11.6` from `0.11.6` to `0.11.7` under `org.scala-lang:toolkit_3:0.8.1`
 - Updated `com.lihaoyi:os-zip:0.11.6` from `0.11.6` to `0.11.7` under `com.lihaoyi:os-lib_3:0.11.7`

## Full dependency tree

 - org.scala-lang:toolkit-test_3:0.8.1
   - org.scala-lang:toolkit_3:0.8.1
     - com.lihaoyi:os-lib_3:0.11.7
       - com.lihaoyi:geny_3:1.1.1
       - com.lihaoyi:os-zip:0.11.7
     - com.lihaoyi:upickle_3:4.4.2
       - com.lihaoyi:ujson_3:4.4.2
         - com.lihaoyi:upickle-core_3:4.4.2
           - com.lihaoyi:geny_3:1.1.1 (already listed)
       - com.lihaoyi:upack_3:4.4.2
         - com.lihaoyi:upickle-core_3:4.4.2 (already listed)
       - com.lihaoyi:upickle-implicits_3:4.4.2
         - com.lihaoyi:upickle-core_3:4.4.2 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.13
       - com.softwaremill.sttp.model:core_3:1.7.17
       - com.softwaremill.sttp.shared:core_3:1.5.0
       - com.softwaremill.sttp.shared:ws_3:1.5.0
         - com.softwaremill.sttp.model:core_3:1.7.12
         - com.softwaremill.sttp.shared:core_3:1.5.0 (already listed)
     - com.softwaremill.sttp.client4:upickle_3:4.0.13
       - com.lihaoyi:upickle_3:4.4.0
         - com.lihaoyi:ujson_3:4.4.2 (already listed)
         - com.lihaoyi:upack_3:4.4.2 (already listed)
         - com.lihaoyi:upickle-implicits_3:4.4.2 (already listed)
       - com.softwaremill.sttp.client4:core_3:4.0.13 (already listed)
       - com.softwaremill.sttp.client4:json-common_3:4.0.13
         - com.softwaremill.sttp.client4:core_3:4.0.13 (already listed)
   - org.scalameta:munit_3:1.2.1
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.2.1
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
     - org.scalameta:munit-diff_3:1.2.1
