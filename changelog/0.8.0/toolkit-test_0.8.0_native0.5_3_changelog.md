# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_native0.5_3:0.7.0` from `0.7.0` to `0.8.0` under `org.scala-lang:toolkit-test_native0.5_3:0.8.0`

## Changes to transitive dependencies
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.2`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.2`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `org.scala-lang:toolkit_native0.5_3:0.8.0`
 - Updated `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.2`
 - Updated `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.2` under `org.scala-lang:toolkit_native0.5_3:0.8.0`
 - Updated `com.softwaremill.sttp.model:core_native0.5_3:1.7.11` from `1.7.11` to `1.7.12` under `com.softwaremill.sttp.shared:ws_native0.5_3:1.5.0`
 - Updated `com.softwaremill.sttp.model:core_native0.5_3:1.7.11` from `1.7.11` to `1.7.13` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.2`
 - Updated `com.softwaremill.sttp.shared:core_native0.5_3:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.2`
 - Updated `com.softwaremill.sttp.shared:core_native0.5_3:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.shared:ws_native0.5_3:1.5.0`
 - Updated `com.softwaremill.sttp.shared:ws_native0.5_3:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.5_3:0.8.0
   - org.scala-lang:toolkit_native0.5_3:0.8.0
     - com.lihaoyi:os-lib_native0.5_3:0.11.3
       - com.lihaoyi:geny_native0.5_3:1.1.1
     - com.lihaoyi:upickle_native0.5_3:4.1.0
       - com.lihaoyi:ujson_native0.5_3:4.1.0
         - com.lihaoyi:upickle-core_native0.5_3:4.1.0
           - com.lihaoyi:geny_native0.5_3:1.1.1 (already listed)
       - com.lihaoyi:upack_native0.5_3:4.1.0
         - com.lihaoyi:upickle-core_native0.5_3:4.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_native0.5_3:4.1.0
         - com.lihaoyi:upickle-core_native0.5_3:4.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_3:4.0.2
       - com.softwaremill.sttp.model:core_native0.5_3:1.7.13
       - com.softwaremill.sttp.shared:core_native0.5_3:1.5.0
       - com.softwaremill.sttp.shared:ws_native0.5_3:1.5.0
         - com.softwaremill.sttp.model:core_native0.5_3:1.7.12
         - com.softwaremill.sttp.shared:core_native0.5_3:1.5.0 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.2
       - com.lihaoyi:upickle_native0.5_3:4.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_native0.5_3:4.0.2 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.2
         - com.softwaremill.sttp.client4:core_native0.5_3:4.0.2 (already listed)
   - org.scalameta:munit_native0.5_3:1.1.0
     - org.scalameta:munit-diff_native0.5_3:1.1.0
