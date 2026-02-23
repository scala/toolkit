# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:upickle_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `org.scala-lang:toolkit_native0.5_3:0.9.1`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.15` from `4.0.15` to `4.0.19` under `org.scala-lang:toolkit_native0.5_3:0.9.1`
 - Updated `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.15` from `4.0.15` to `4.0.19` under `org.scala-lang:toolkit_native0.5_3:0.9.1`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle_native0.5_3:4.4.3`
 - Updated `com.lihaoyi:upack_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle_native0.5_3:4.4.3`
 - Updated `com.lihaoyi:upickle-core_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:ujson_native0.5_3:4.4.3`
 - Updated `com.lihaoyi:upickle-core_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upack_native0.5_3:4.4.3`
 - Updated `com.lihaoyi:upickle-core_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle-implicits_native0.5_3:4.4.3`
 - Updated `com.lihaoyi:upickle-implicits_native0.5_3:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle_native0.5_3:4.4.3`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.15` from `4.0.15` to `4.0.19` under `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.19`
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.15` from `4.0.15` to `4.0.19` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.19`
 - Updated `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.15` from `4.0.15` to `4.0.19` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.19`

## Full dependency tree

 - org.scala-lang:toolkit_native0.5_3:0.9.1
   - com.lihaoyi:os-lib_native0.5_3:0.11.8
     - com.lihaoyi:geny_native0.5_3:1.1.1
   - com.lihaoyi:upickle_native0.5_3:4.4.3
     - com.lihaoyi:ujson_native0.5_3:4.4.3
       - com.lihaoyi:upickle-core_native0.5_3:4.4.3
         - com.lihaoyi:geny_native0.5_3:1.1.1 (already listed)
     - com.lihaoyi:upack_native0.5_3:4.4.3
       - com.lihaoyi:upickle-core_native0.5_3:4.4.3 (already listed)
     - com.lihaoyi:upickle-implicits_native0.5_3:4.4.3
       - com.lihaoyi:upickle-core_native0.5_3:4.4.3 (already listed)
   - com.softwaremill.sttp.client4:core_native0.5_3:4.0.19
     - com.softwaremill.sttp.model:core_native0.5_3:1.7.17
     - com.softwaremill.sttp.shared:core_native0.5_3:1.5.0
     - com.softwaremill.sttp.shared:ws_native0.5_3:1.5.0
       - com.softwaremill.sttp.model:core_native0.5_3:1.7.12
       - com.softwaremill.sttp.shared:core_native0.5_3:1.5.0 (already listed)
   - com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.19
     - com.lihaoyi:upickle_native0.5_3:4.4.1
       - com.lihaoyi:ujson_native0.5_3:4.4.3 (already listed)
       - com.lihaoyi:upack_native0.5_3:4.4.3 (already listed)
       - com.lihaoyi:upickle-implicits_native0.5_3:4.4.3 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_3:4.0.19 (already listed)
     - com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.19
       - com.softwaremill.sttp.client4:core_native0.5_3:4.0.19 (already listed)
