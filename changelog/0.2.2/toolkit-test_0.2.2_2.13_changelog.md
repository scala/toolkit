# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_2.13:0.2.1` from `0.2.1` to `0.2.2` under `org.scala-lang:toolkit-test_2.13:0.2.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_2.13:0.2.2
   - org.scala-lang:toolkit_2.13:0.2.2
     - com.lihaoyi:os-lib_2.13:0.9.1
       - com.lihaoyi:geny_2.13:1.0.0
     - com.lihaoyi:upickle_2.13:3.1.3
       - com.lihaoyi:ujson_2.13:3.1.3
         - com.lihaoyi:upickle-core_2.13:3.1.3
           - com.lihaoyi:geny_2.13:1.0.0 (already listed)
       - com.lihaoyi:upack_2.13:3.1.3
         - com.lihaoyi:upickle-core_2.13:3.1.3 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:3.1.3
         - com.lihaoyi:upickle-core_2.13:3.1.3 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.0-M6
       - com.softwaremill.sttp.model:core_2.13:1.7.2
       - com.softwaremill.sttp.shared:core_2.13:1.3.16
       - com.softwaremill.sttp.shared:ws_2.13:1.3.16
         - com.softwaremill.sttp.model:core_2.13:1.6.0
         - com.softwaremill.sttp.shared:core_2.13:1.3.16 (already listed)
     - com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M6
       - com.lihaoyi:upickle_2.13:3.1.3 (already listed)
       - com.softwaremill.sttp.client4:core_2.13:4.0.0-M6 (already listed)
       - com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M6
         - com.softwaremill.sttp.client4:core_2.13:4.0.0-M6 (already listed)
   - org.scalameta:munit_2.13:1.0.0-M10
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.0-M10
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
