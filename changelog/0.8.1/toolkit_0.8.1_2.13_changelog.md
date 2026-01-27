# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:os-lib_2.13:0.11.6` from `0.11.6` to `0.11.7` under `org.scala-lang:toolkit_2.13:0.8.1`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:os-zip:0.11.6` from `0.11.6` to `0.11.7` under `com.lihaoyi:os-lib_2.13:0.11.7`

## Full dependency tree

 - org.scala-lang:toolkit_2.13:0.8.1
   - com.lihaoyi:os-lib_2.13:0.11.7
     - com.lihaoyi:geny_2.13:1.1.1
     - com.lihaoyi:os-zip:0.11.7
   - com.lihaoyi:upickle_2.13:4.4.2
     - com.lihaoyi:ujson_2.13:4.4.2
       - com.lihaoyi:upickle-core_2.13:4.4.2
         - com.lihaoyi:geny_2.13:1.1.1 (already listed)
     - com.lihaoyi:upack_2.13:4.4.2
       - com.lihaoyi:upickle-core_2.13:4.4.2 (already listed)
     - com.lihaoyi:upickle-implicits_2.13:4.4.2
       - com.lihaoyi:upickle-core_2.13:4.4.2 (already listed)
   - com.softwaremill.sttp.client4:core_2.13:4.0.13
     - com.softwaremill.sttp.model:core_2.13:1.7.17
     - com.softwaremill.sttp.shared:core_2.13:1.5.0
     - com.softwaremill.sttp.shared:ws_2.13:1.5.0
       - com.softwaremill.sttp.model:core_2.13:1.7.12
       - com.softwaremill.sttp.shared:core_2.13:1.5.0 (already listed)
   - com.softwaremill.sttp.client4:upickle_2.13:4.0.13
     - com.lihaoyi:upickle_2.13:4.4.0
       - com.lihaoyi:ujson_2.13:4.4.2 (already listed)
       - com.lihaoyi:upack_2.13:4.4.2 (already listed)
       - com.lihaoyi:upickle-implicits_2.13:4.4.2 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.13 (already listed)
     - com.softwaremill.sttp.client4:json-common_2.13:4.0.13
       - com.softwaremill.sttp.client4:core_2.13:4.0.13 (already listed)
