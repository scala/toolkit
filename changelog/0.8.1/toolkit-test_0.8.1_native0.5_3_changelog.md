# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_native0.5_3:0.8.0` from `0.8.0` to `0.8.1` under `org.scala-lang:toolkit-test_native0.5_3:0.8.1`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-lib_native0.5_3:0.11.6` from `0.11.6` to `0.11.7` under `org.scala-lang:toolkit_native0.5_3:0.8.1`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.5_3:0.8.1
   - org.scala-lang:toolkit_native0.5_3:0.8.1
     - com.lihaoyi:os-lib_native0.5_3:0.11.7
       - com.lihaoyi:geny_native0.5_3:1.1.1
     - com.lihaoyi:upickle_native0.5_3:4.4.2
       - com.lihaoyi:ujson_native0.5_3:4.4.2
         - com.lihaoyi:upickle-core_native0.5_3:4.4.2
           - com.lihaoyi:geny_native0.5_3:1.1.1 (already listed)
       - com.lihaoyi:upack_native0.5_3:4.4.2
         - com.lihaoyi:upickle-core_native0.5_3:4.4.2 (already listed)
       - com.lihaoyi:upickle-implicits_native0.5_3:4.4.2
         - com.lihaoyi:upickle-core_native0.5_3:4.4.2 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_3:4.0.13
       - com.softwaremill.sttp.model:core_native0.5_3:1.7.17
       - com.softwaremill.sttp.shared:core_native0.5_3:1.5.0
       - com.softwaremill.sttp.shared:ws_native0.5_3:1.5.0
         - com.softwaremill.sttp.model:core_native0.5_3:1.7.12
         - com.softwaremill.sttp.shared:core_native0.5_3:1.5.0 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.13
       - com.lihaoyi:upickle_native0.5_3:4.4.0
         - com.lihaoyi:ujson_native0.5_3:4.4.2 (already listed)
         - com.lihaoyi:upack_native0.5_3:4.4.2 (already listed)
         - com.lihaoyi:upickle-implicits_native0.5_3:4.4.2 (already listed)
       - com.softwaremill.sttp.client4:core_native0.5_3:4.0.13 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.13
         - com.softwaremill.sttp.client4:core_native0.5_3:4.0.13 (already listed)
   - org.scalameta:munit_native0.5_3:1.2.1
     - org.scalameta:munit-diff_native0.5_3:1.2.1
