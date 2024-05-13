# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_native0.4_2.13:0.2.1` from `0.2.1` to `0.2.2` under `org.scala-lang:toolkit-test_native0.4_2.13:0.2.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.4_2.13:0.2.2
   - org.scala-lang:toolkit_native0.4_2.13:0.2.2
     - com.lihaoyi:os-lib_native0.4_2.13:0.9.1
       - com.lihaoyi:geny_native0.4_2.13:1.0.0
     - com.lihaoyi:upickle_native0.4_2.13:3.1.3
       - com.lihaoyi:ujson_native0.4_2.13:3.1.3
         - com.lihaoyi:upickle-core_native0.4_2.13:3.1.3
           - com.lihaoyi:geny_native0.4_2.13:1.0.0 (already listed)
       - com.lihaoyi:upack_native0.4_2.13:3.1.3
         - com.lihaoyi:upickle-core_native0.4_2.13:3.1.3 (already listed)
       - com.lihaoyi:upickle-implicits_native0.4_2.13:3.1.3
         - com.lihaoyi:upickle-core_native0.4_2.13:3.1.3 (already listed)
     - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M6
       - com.softwaremill.sttp.model:core_native0.4_2.13:1.7.2
       - com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.16
       - com.softwaremill.sttp.shared:ws_native0.4_2.13:1.3.16
         - com.softwaremill.sttp.model:core_native0.4_2.13:1.6.0
         - com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.16 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M6
       - com.lihaoyi:upickle_native0.4_2.13:3.1.3 (already listed)
       - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M6 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.4_2.13:4.0.0-M6
         - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M6 (already listed)
   - org.scalameta:munit_native0.4_2.13:1.0.0-M10
