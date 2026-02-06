# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:os-lib_2.13:0.11.7` from `0.11.7` to `0.11.8` under `org.scala-lang:toolkit_2.13:0.9.0`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.13` from `4.0.13` to `4.0.15` under `org.scala-lang:toolkit_2.13:0.9.0`
 - Updated `com.softwaremill.sttp.client4:upickle_2.13:4.0.13` from `4.0.13` to `4.0.15` under `org.scala-lang:toolkit_2.13:0.9.0`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-zip:0.11.7` from `0.11.7` to `0.11.8` under `com.lihaoyi:os-lib_2.13:0.11.8`
 - Updated `com.lihaoyi:upickle_2.13:4.4.0` from `4.4.0` to `4.4.1` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.15`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.13` from `4.0.13` to `4.0.15` under `com.softwaremill.sttp.client4:json-common_2.13:4.0.15`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.13` from `4.0.13` to `4.0.15` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.15`
 - Updated `com.softwaremill.sttp.client4:json-common_2.13:4.0.13` from `4.0.13` to `4.0.15` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.15`

## Full dependency tree

 - org.scala-lang:toolkit_2.13:0.9.0
   - com.lihaoyi:os-lib_2.13:0.11.8
     - com.lihaoyi:geny_2.13:1.1.1
     - com.lihaoyi:os-zip:0.11.8
   - com.lihaoyi:upickle_2.13:4.4.2
     - com.lihaoyi:ujson_2.13:4.4.2
       - com.lihaoyi:upickle-core_2.13:4.4.2
         - com.lihaoyi:geny_2.13:1.1.1 (already listed)
     - com.lihaoyi:upack_2.13:4.4.2
       - com.lihaoyi:upickle-core_2.13:4.4.2 (already listed)
     - com.lihaoyi:upickle-implicits_2.13:4.4.2
       - com.lihaoyi:upickle-core_2.13:4.4.2 (already listed)
   - com.softwaremill.sttp.client4:core_2.13:4.0.15
     - com.softwaremill.sttp.model:core_2.13:1.7.17
     - com.softwaremill.sttp.shared:core_2.13:1.5.0
     - com.softwaremill.sttp.shared:ws_2.13:1.5.0
       - com.softwaremill.sttp.model:core_2.13:1.7.12
       - com.softwaremill.sttp.shared:core_2.13:1.5.0 (already listed)
   - com.softwaremill.sttp.client4:upickle_2.13:4.0.15
     - com.lihaoyi:upickle_2.13:4.4.1
       - com.lihaoyi:ujson_2.13:4.4.2 (already listed)
       - com.lihaoyi:upack_2.13:4.4.2 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:4.4.2 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.15 (already listed)
     - com.softwaremill.sttp.client4:json-common_2.13:4.0.15
       - com.softwaremill.sttp.client4:core_2.13:4.0.15 (already listed)
