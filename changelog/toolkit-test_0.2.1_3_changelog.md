# Changelog for toolkit-test 0.2.1

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_3:0.2.0` from `0.2.0` to `0.2.1` under `org.scala-lang:toolkit-test_3:0.2.1`

## Full dependency tree

 - org.scala-lang:toolkit-test_3:0.2.1
   - org.scala-lang:toolkit_3:0.2.1
     - com.lihaoyi:os-lib_3:0.9.1
       - com.lihaoyi:geny_3:1.0.0
     - com.lihaoyi:upickle_3:3.1.0
       - com.lihaoyi:ujson_3:3.1.0
         - com.lihaoyi:upickle-core_3:3.1.0
           - com.lihaoyi:geny_3:1.0.0 (already listed)
       - com.lihaoyi:upack_3:3.1.0
         - com.lihaoyi:upickle-core_3:3.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_3:3.1.0
         - com.lihaoyi:upickle-core_3:3.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.0-M1
       - com.softwaremill.sttp.model:core_3:1.5.5
       - com.softwaremill.sttp.shared:core_3:1.3.13
       - com.softwaremill.sttp.shared:ws_3:1.3.13
         - com.softwaremill.sttp.model:core_3:1.5.5 (already listed)
         - com.softwaremill.sttp.shared:core_3:1.3.13 (already listed)
     - com.softwaremill.sttp.client4:upickle_3:4.0.0-M1
       - com.lihaoyi:upickle_3:3.0.0
         - com.lihaoyi:ujson_3:3.1.0 (already listed)
         - com.lihaoyi:upack_3:3.1.0 (already listed)
         - com.lihaoyi:upickle-implicits_3:3.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_3:4.0.0-M1 (already listed)
       - com.softwaremill.sttp.client4:json-common_3:4.0.0-M1
         - com.softwaremill.sttp.client4:core_3:4.0.0-M1 (already listed)
   - org.scalameta:munit_3:1.0.0-M7
     - junit:junit:4.13.1
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.0-M7
       - junit:junit:4.13.2
         - org.hamcrest:hamcrest-core:1.3.0 (already listed)
       - org.scala-sbt:test-interface:1.0.0
