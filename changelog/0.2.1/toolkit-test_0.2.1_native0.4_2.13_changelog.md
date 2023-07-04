# Changelog for toolkit-test 0.2.1

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_native0.4_2.13:0.2.0` from `0.2.0` to `0.2.1` under `org.scala-lang:toolkit-test_native0.4_2.13:0.2.1`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.4_2.13:0.2.1
   - org.scala-lang:toolkit_native0.4_2.13:0.2.1
     - com.lihaoyi:os-lib_native0.4_2.13:0.9.1
       - com.lihaoyi:geny_native0.4_2.13:1.0.0
     - com.lihaoyi:upickle_native0.4_2.13:3.1.0
       - com.lihaoyi:ujson_native0.4_2.13:3.1.0
         - com.lihaoyi:upickle-core_native0.4_2.13:3.1.0
           - com.lihaoyi:geny_native0.4_2.13:1.0.0 (already listed)
       - com.lihaoyi:upack_native0.4_2.13:3.1.0
         - com.lihaoyi:upickle-core_native0.4_2.13:3.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_native0.4_2.13:3.1.0
         - com.lihaoyi:upickle-core_native0.4_2.13:3.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M1
       - com.softwaremill.sttp.model:core_native0.4_2.13:1.5.5
       - com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.13
       - com.softwaremill.sttp.shared:ws_native0.4_2.13:1.3.13
         - com.softwaremill.sttp.model:core_native0.4_2.13:1.5.5 (already listed)
         - com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.13 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M1
       - com.lihaoyi:upickle_native0.4_2.13:3.0.0
         - com.lihaoyi:ujson_native0.4_2.13:3.1.0 (already listed)
         - com.lihaoyi:upack_native0.4_2.13:3.1.0 (already listed)
         - com.lihaoyi:upickle-implicits_native0.4_2.13:3.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M1 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.4_2.13:4.0.0-M1
         - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M1 (already listed)
   - org.scalameta:munit_native0.4_2.13:1.0.0-M7
