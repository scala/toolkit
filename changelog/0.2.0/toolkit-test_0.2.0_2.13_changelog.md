# Changelog for toolkit-test 0.2.0

## Changes to direct dependencies
 - Added `org.scala-lang:toolkit_2.13:0.2.0` under `org.scala-lang:toolkit-test_2.13:0.2.0`

## Changes to transitive dependencies
 - Added `com.lihaoyi:geny_2.13:1.0.0` under `com.lihaoyi:os-lib_2.13:0.9.1`
 - Added `com.lihaoyi:geny_2.13:1.0.0` under `com.lihaoyi:upickle-core_2.13:3.1.0`
 - Added `com.lihaoyi:os-lib_2.13:0.9.1` under `org.scala-lang:toolkit_2.13:0.2.0`
 - Added `com.lihaoyi:ujson_2.13:3.1.0` under `com.lihaoyi:upickle_2.13:3.0.0`
 - Added `com.lihaoyi:ujson_2.13:3.1.0` under `com.lihaoyi:upickle_2.13:3.1.0`
 - Added `com.lihaoyi:upack_2.13:3.1.0` under `com.lihaoyi:upickle_2.13:3.0.0`
 - Added `com.lihaoyi:upack_2.13:3.1.0` under `com.lihaoyi:upickle_2.13:3.1.0`
 - Added `com.lihaoyi:upickle-core_2.13:3.1.0` under `com.lihaoyi:ujson_2.13:3.1.0`
 - Added `com.lihaoyi:upickle-core_2.13:3.1.0` under `com.lihaoyi:upack_2.13:3.1.0`
 - Added `com.lihaoyi:upickle-core_2.13:3.1.0` under `com.lihaoyi:upickle-implicits_2.13:3.1.0`
 - Added `com.lihaoyi:upickle-implicits_2.13:3.1.0` under `com.lihaoyi:upickle_2.13:3.0.0`
 - Added `com.lihaoyi:upickle-implicits_2.13:3.1.0` under `com.lihaoyi:upickle_2.13:3.1.0`
 - Added `com.lihaoyi:upickle_2.13:3.0.0` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M1`
 - Added `com.lihaoyi:upickle_2.13:3.1.0` under `org.scala-lang:toolkit_2.13:0.2.0`
 - Added `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1` under `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M1`
 - Added `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M1`
 - Added `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1` under `org.scala-lang:toolkit_2.13:0.2.0`
 - Added `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M1` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M1`
 - Added `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M1` under `org.scala-lang:toolkit_2.13:0.2.0`
 - Added `com.softwaremill.sttp.model:core_2.13:1.5.5` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1`
 - Added `com.softwaremill.sttp.model:core_2.13:1.5.5` under `com.softwaremill.sttp.shared:ws_2.13:1.3.13`
 - Added `com.softwaremill.sttp.shared:core_2.13:1.3.13` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1`
 - Added `com.softwaremill.sttp.shared:core_2.13:1.3.13` under `com.softwaremill.sttp.shared:ws_2.13:1.3.13`
 - Added `com.softwaremill.sttp.shared:ws_2.13:1.3.13` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1`

## Full dependency tree

 - org.scala-lang:toolkit-test_2.13:0.2.0
   - org.scala-lang:toolkit_2.13:0.2.0
     - com.lihaoyi:os-lib_2.13:0.9.1
       - com.lihaoyi:geny_2.13:1.0.0
     - com.lihaoyi:upickle_2.13:3.1.0
       - com.lihaoyi:ujson_2.13:3.1.0
         - com.lihaoyi:upickle-core_2.13:3.1.0
           - com.lihaoyi:geny_2.13:1.0.0 (already listed)
       - com.lihaoyi:upack_2.13:3.1.0
         - com.lihaoyi:upickle-core_2.13:3.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:3.1.0
         - com.lihaoyi:upickle-core_2.13:3.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.0-M1
       - com.softwaremill.sttp.model:core_2.13:1.5.5
       - com.softwaremill.sttp.shared:core_2.13:1.3.13
       - com.softwaremill.sttp.shared:ws_2.13:1.3.13
         - com.softwaremill.sttp.model:core_2.13:1.5.5 (already listed)
         - com.softwaremill.sttp.shared:core_2.13:1.3.13 (already listed)
     - com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M1
       - com.lihaoyi:upickle_2.13:3.0.0
         - com.lihaoyi:ujson_2.13:3.1.0 (already listed)
         - com.lihaoyi:upack_2.13:3.1.0 (already listed)
         - com.lihaoyi:upickle-implicits_2.13:3.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_2.13:4.0.0-M1 (already listed)
       - com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M1
         - com.softwaremill.sttp.client4:core_2.13:4.0.0-M1 (already listed)
   - org.scalameta:munit_2.13:1.0.0-M7
     - junit:junit:4.13.1
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.0-M7
       - junit:junit:4.13.2
         - org.hamcrest:hamcrest-core:1.3.0 (already listed)
       - org.scala-sbt:test-interface:1.0.0
