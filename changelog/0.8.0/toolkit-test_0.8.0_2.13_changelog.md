# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_2.13:0.7.0` from `0.7.0` to `0.8.0` under `org.scala-lang:toolkit-test_2.13:0.8.0`

## Changes to transitive dependencies
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `com.softwaremill.sttp.client4:json-common_2.13:4.0.2`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.2`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `org.scala-lang:toolkit_2.13:0.8.0`
 - Updated `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.2`
 - Updated `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `org.scala-lang:toolkit_2.13:0.8.0`
 - Updated `com.softwaremill.sttp.model:core_2.13:1.7.11` from `1.7.11` to `1.7.12` under `com.softwaremill.sttp.shared:ws_2.13:1.5.0`
 - Updated `com.softwaremill.sttp.model:core_2.13:1.7.11` from `1.7.11` to `1.7.13` under `com.softwaremill.sttp.client4:core_2.13:4.0.2`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.client4:core_2.13:4.0.2`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.shared:ws_2.13:1.5.0`
 - Updated `com.softwaremill.sttp.shared:ws_2.13:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.client4:core_2.13:4.0.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_2.13:0.8.0
   - org.scala-lang:toolkit_2.13:0.8.0
     - com.lihaoyi:os-lib_2.13:0.11.3
       - com.lihaoyi:geny_2.13:1.1.1
     - com.lihaoyi:upickle_2.13:4.1.0
       - com.lihaoyi:ujson_2.13:4.1.0
         - com.lihaoyi:upickle-core_2.13:4.1.0
           - com.lihaoyi:geny_2.13:1.1.1 (already listed)
       - com.lihaoyi:upack_2.13:4.1.0
         - com.lihaoyi:upickle-core_2.13:4.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:4.1.0
         - com.lihaoyi:upickle-core_2.13:4.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.2
       - com.softwaremill.sttp.model:core_2.13:1.7.13
       - com.softwaremill.sttp.shared:core_2.13:1.5.0
       - com.softwaremill.sttp.shared:ws_2.13:1.5.0
         - com.softwaremill.sttp.model:core_2.13:1.7.12
         - com.softwaremill.sttp.shared:core_2.13:1.5.0 (already listed)
     - com.softwaremill.sttp.client4:upickle_2.13:4.0.2
       - com.lihaoyi:upickle_2.13:4.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_2.13:4.0.2 (already listed)
       - com.softwaremill.sttp.client4:json-common_2.13:4.0.2
         - com.softwaremill.sttp.client4:core_2.13:4.0.2 (already listed)
   - org.scalameta:munit_2.13:1.1.0
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.1.0
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
     - org.scalameta:munit-diff_2.13:1.1.0
