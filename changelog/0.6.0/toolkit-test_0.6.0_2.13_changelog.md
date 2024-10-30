# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_2.13:0.5.0` from `0.5.0` to `0.6.0` under `org.scala-lang:toolkit-test_2.13:0.6.0`
 - Updated `org.scalameta:munit_2.13:1.0.0` from `1.0.0` to `1.0.2` under `org.scala-lang:toolkit-test_2.13:0.6.0`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-lib_2.13:0.10.3` from `0.10.3` to `0.11.3` under `org.scala-lang:toolkit_2.13:0.6.0`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M19` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M19` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `org.scala-lang:toolkit_2.13:0.6.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M19` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `org.scala-lang:toolkit_2.13:0.6.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_2.13:1.7.10` from `1.7.10` to `1.7.11` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M19`
 - Updated `com.softwaremill.sttp.model:core_2.13:1.7.10` from `1.7.10` to `1.7.11` under `com.softwaremill.sttp.shared:ws_2.13:1.3.22`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.3.19` from `1.3.19` to `1.3.22` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M19`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.3.19` from `1.3.19` to `1.3.22` under `com.softwaremill.sttp.shared:ws_2.13:1.3.22`
 - Updated `com.softwaremill.sttp.shared:ws_2.13:1.3.19` from `1.3.19` to `1.3.22` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M19`
 - Updated `org.scalameta:junit-interface:1.0.0` from `1.0.0` to `1.0.2` under `org.scalameta:munit_2.13:1.0.2`
 - Updated `org.scalameta:munit-diff_2.13:1.0.0` from `1.0.0` to `1.0.2` under `org.scalameta:munit_2.13:1.0.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_2.13:0.6.0
   - org.scala-lang:toolkit_2.13:0.6.0
     - com.lihaoyi:os-lib_2.13:0.11.3
       - com.lihaoyi:geny_2.13:1.1.1
     - com.lihaoyi:upickle_2.13:3.3.1
       - com.lihaoyi:ujson_2.13:3.3.1
         - com.lihaoyi:upickle-core_2.13:3.3.1
           - com.lihaoyi:geny_2.13:1.1.0
       - com.lihaoyi:upack_2.13:3.3.1
         - com.lihaoyi:upickle-core_2.13:3.3.1 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:3.3.1
         - com.lihaoyi:upickle-core_2.13:3.3.1 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.0-M19
       - com.softwaremill.sttp.model:core_2.13:1.7.11
       - com.softwaremill.sttp.shared:core_2.13:1.3.22
       - com.softwaremill.sttp.shared:ws_2.13:1.3.22
         - com.softwaremill.sttp.model:core_2.13:1.7.11 (already listed)
         - com.softwaremill.sttp.shared:core_2.13:1.3.22 (already listed)
     - com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M19
       - com.lihaoyi:upickle_2.13:3.3.1 (already listed)
       - com.softwaremill.sttp.client4:core_2.13:4.0.0-M19 (already listed)
       - com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M19
         - com.softwaremill.sttp.client4:core_2.13:4.0.0-M19 (already listed)
   - org.scalameta:munit_2.13:1.0.2
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.2
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
     - org.scalameta:munit-diff_2.13:1.0.2
