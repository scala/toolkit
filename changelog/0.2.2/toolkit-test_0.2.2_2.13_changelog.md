# Changelog for toolkit-test 0.2.2

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_2.13:0.2.1` from `0.2.1` to `0.2.2` under `org.scala-lang:toolkit-test_2.13:0.2.2`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-lib_2.13:0.9.1` from `0.9.1` to `0.9.3` under `org.scala-lang:toolkit_2.13:0.2.2`
 - Updated `com.lihaoyi:ujson_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.lihaoyi:upickle_2.13:3.1.4`
 - Updated `com.lihaoyi:upack_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.lihaoyi:upickle_2.13:3.1.4`
 - Updated `com.lihaoyi:upickle-core_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.lihaoyi:ujson_2.13:3.1.4`
 - Updated `com.lihaoyi:upickle-core_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.lihaoyi:upack_2.13:3.1.4`
 - Updated `com.lihaoyi:upickle-core_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.lihaoyi:upickle-implicits_2.13:3.1.4`
 - Updated `com.lihaoyi:upickle-implicits_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.lihaoyi:upickle_2.13:3.1.4`
 - Updated `com.lihaoyi:upickle_2.13:3.1.3` from `3.1.3` to `3.1.4` under `org.scala-lang:toolkit_2.13:0.2.2`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M8` under `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M8` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M8` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M8` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M8` under `org.scala-lang:toolkit_2.13:0.2.2` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M8` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M8` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M8` under `org.scala-lang:toolkit_2.13:0.2.2` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_2.13:1.7.2` from `1.7.2` to `1.7.6` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M8`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M8`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.shared:ws_2.13:1.3.17`
 - Updated `com.softwaremill.sttp.shared:ws_2.13:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M8`

## Full dependency tree

 - org.scala-lang:toolkit-test_2.13:0.2.2
   - org.scala-lang:toolkit_2.13:0.2.2
     - com.lihaoyi:os-lib_2.13:0.9.3
       - com.lihaoyi:geny_2.13:1.0.0
     - com.lihaoyi:upickle_2.13:3.1.4
       - com.lihaoyi:ujson_2.13:3.1.4
         - com.lihaoyi:upickle-core_2.13:3.1.4
           - com.lihaoyi:geny_2.13:1.0.0 (already listed)
       - com.lihaoyi:upack_2.13:3.1.4
         - com.lihaoyi:upickle-core_2.13:3.1.4 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:3.1.4
         - com.lihaoyi:upickle-core_2.13:3.1.4 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.0-M8
       - com.softwaremill.sttp.model:core_2.13:1.7.6
       - com.softwaremill.sttp.shared:core_2.13:1.3.17
       - com.softwaremill.sttp.shared:ws_2.13:1.3.17
         - com.softwaremill.sttp.model:core_2.13:1.6.0
         - com.softwaremill.sttp.shared:core_2.13:1.3.17 (already listed)
     - com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M8
       - com.lihaoyi:upickle_2.13:3.1.3
         - com.lihaoyi:ujson_2.13:3.1.4 (already listed)
         - com.lihaoyi:upack_2.13:3.1.4 (already listed)
         - com.lihaoyi:upickle-implicits_2.13:3.1.4 (already listed)
       - com.softwaremill.sttp.client4:core_2.13:4.0.0-M8 (already listed)
       - com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M8
         - com.softwaremill.sttp.client4:core_2.13:4.0.0-M8 (already listed)
   - org.scalameta:munit_2.13:1.0.0-M10
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.0-M10
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
