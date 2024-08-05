# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_native0.5_2.13:0.4.0` from `0.4.0` to `0.5.0` under `org.scala-lang:toolkit-test_native0.5_2.13:0.5.0`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-lib_native0.5_2.13:0.10.0` from `0.10.0` to `0.10.2` under `org.scala-lang:toolkit_native0.5_2.13:0.5.0`
 - Updated `com.lihaoyi:ujson_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_native0.5_2.13:3.3.1`
 - Updated `com.lihaoyi:upack_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_native0.5_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:ujson_native0.5_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upack_native0.5_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle-implicits_native0.5_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-implicits_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_native0.5_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle_native0.5_2.13:3.3.0` from `3.3.0` to `3.3.1` under `org.scala-lang:toolkit_native0.5_2.13:0.5.0`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.5_2.13:0.5.0
   - org.scala-lang:toolkit_native0.5_2.13:0.5.0
     - com.lihaoyi:os-lib_native0.5_2.13:0.10.2
       - com.lihaoyi:geny_native0.5_2.13:1.1.0
     - com.lihaoyi:upickle_native0.5_2.13:3.3.1
       - com.lihaoyi:ujson_native0.5_2.13:3.3.1
         - com.lihaoyi:upickle-core_native0.5_2.13:3.3.1
           - com.lihaoyi:geny_native0.5_2.13:1.1.0 (already listed)
       - com.lihaoyi:upack_native0.5_2.13:3.3.1
         - com.lihaoyi:upickle-core_native0.5_2.13:3.3.1 (already listed)
       - com.lihaoyi:upickle-implicits_native0.5_2.13:3.3.1
         - com.lihaoyi:upickle-core_native0.5_2.13:3.3.1 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.0-M14
       - com.softwaremill.sttp.model:core_native0.5_2.13:1.7.10
       - com.softwaremill.sttp.shared:core_native0.5_2.13:1.3.18
       - com.softwaremill.sttp.shared:ws_native0.5_2.13:1.3.18
         - com.softwaremill.sttp.model:core_native0.5_2.13:1.7.10 (already listed)
         - com.softwaremill.sttp.shared:core_native0.5_2.13:1.3.18 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.5_2.13:4.0.0-M14
       - com.lihaoyi:upickle_native0.5_2.13:3.3.0
         - com.lihaoyi:ujson_native0.5_2.13:3.3.1 (already listed)
         - com.lihaoyi:upack_native0.5_2.13:3.3.1 (already listed)
         - com.lihaoyi:upickle-implicits_native0.5_2.13:3.3.1 (already listed)
       - com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.0-M14 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.5_2.13:4.0.0-M14
         - com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.0-M14 (already listed)
   - org.scalameta:munit_native0.5_2.13:1.0.0-RC1
     - org.scalameta:munit-diff_native0.5_2.13:1.0.0-RC1
