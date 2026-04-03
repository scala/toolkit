# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_native0.5_2.13:0.9.1` from `0.9.1` to `0.9.2` under `org.scala-lang:toolkit-test_native0.5_2.13:0.9.2`

## Changes to transitive dependencies
 - Updated `com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.19` from `4.0.19` to `4.0.21` under `com.softwaremill.sttp.client4:json-common_native0.5_2.13:4.0.21`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.19` from `4.0.19` to `4.0.21` under `com.softwaremill.sttp.client4:upickle_native0.5_2.13:4.0.21`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.19` from `4.0.19` to `4.0.21` under `org.scala-lang:toolkit_native0.5_2.13:0.9.2`
 - Updated `com.softwaremill.sttp.client4:json-common_native0.5_2.13:4.0.19` from `4.0.19` to `4.0.21` under `com.softwaremill.sttp.client4:upickle_native0.5_2.13:4.0.21`
 - Updated `com.softwaremill.sttp.client4:upickle_native0.5_2.13:4.0.19` from `4.0.19` to `4.0.21` under `org.scala-lang:toolkit_native0.5_2.13:0.9.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.5_2.13:0.9.2
   - org.scala-lang:toolkit_native0.5_2.13:0.9.2
     - com.lihaoyi:os-lib_native0.5_2.13:0.11.8
       - com.lihaoyi:geny_native0.5_2.13:1.1.1
     - com.lihaoyi:upickle_native0.5_2.13:4.4.3
       - com.lihaoyi:ujson_native0.5_2.13:4.4.3
         - com.lihaoyi:upickle-core_native0.5_2.13:4.4.3
           - com.lihaoyi:geny_native0.5_2.13:1.1.1 (already listed)
       - com.lihaoyi:upack_native0.5_2.13:4.4.3
         - com.lihaoyi:upickle-core_native0.5_2.13:4.4.3 (already listed)
       - com.lihaoyi:upickle-implicits_native0.5_2.13:4.4.3
         - com.lihaoyi:upickle-core_native0.5_2.13:4.4.3 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.21
       - com.softwaremill.sttp.model:core_native0.5_2.13:1.7.17
       - com.softwaremill.sttp.shared:core_native0.5_2.13:1.5.0
       - com.softwaremill.sttp.shared:ws_native0.5_2.13:1.5.0
         - com.softwaremill.sttp.model:core_native0.5_2.13:1.7.12
         - com.softwaremill.sttp.shared:core_native0.5_2.13:1.5.0 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.5_2.13:4.0.21
       - com.lihaoyi:upickle_native0.5_2.13:4.4.1
         - com.lihaoyi:ujson_native0.5_2.13:4.4.3 (already listed)
         - com.lihaoyi:upack_native0.5_2.13:4.4.3 (already listed)
         - com.lihaoyi:upickle-implicits_native0.5_2.13:4.4.3 (already listed)
       - com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.21 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.5_2.13:4.0.21
         - com.softwaremill.sttp.client4:core_native0.5_2.13:4.0.21 (already listed)
   - org.scalameta:munit_native0.5_2.13:1.2.1
     - org.scalameta:munit-diff_native0.5_2.13:1.2.1
