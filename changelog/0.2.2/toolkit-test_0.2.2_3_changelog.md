# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_3:0.2.1` from `0.2.1` to `0.2.2` under `org.scala-lang:toolkit-test_3:0.2.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_3:0.2.2
   - org.scala-lang:toolkit_3:0.2.2
     - com.lihaoyi:os-lib_3:0.9.1
       - com.lihaoyi:geny_3:1.0.0
     - com.lihaoyi:upickle_3:3.1.3
       - com.lihaoyi:ujson_3:3.1.3
         - com.lihaoyi:upickle-core_3:3.1.3
           - com.lihaoyi:geny_3:1.0.0 (already listed)
       - com.lihaoyi:upack_3:3.1.3
         - com.lihaoyi:upickle-core_3:3.1.3 (already listed)
       - com.lihaoyi:upickle-implicits_3:3.1.3
         - com.lihaoyi:upickle-core_3:3.1.3 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.0-M6
       - com.softwaremill.sttp.model:core_3:1.7.2
       - com.softwaremill.sttp.shared:core_3:1.3.16
       - com.softwaremill.sttp.shared:ws_3:1.3.16
         - com.softwaremill.sttp.model:core_3:1.6.0
         - com.softwaremill.sttp.shared:core_3:1.3.16 (already listed)
     - com.softwaremill.sttp.client4:upickle_3:4.0.0-M6
       - com.lihaoyi:upickle_3:3.1.3 (already listed)
       - com.softwaremill.sttp.client4:core_3:4.0.0-M6 (already listed)
       - com.softwaremill.sttp.client4:json-common_3:4.0.0-M6
         - com.softwaremill.sttp.client4:core_3:4.0.0-M6 (already listed)
   - org.scalameta:munit_3:1.0.0-M10
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.0-M10
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
