# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.19` from `4.0.19` to `4.0.21` under `org.scala-lang:toolkit_3:0.9.2`
 - Updated `com.softwaremill.sttp.client4:upickle_3:4.0.19` from `4.0.19` to `4.0.21` under `org.scala-lang:toolkit_3:0.9.2`

## Changes to transitive dependencies
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.19` from `4.0.19` to `4.0.21` under `com.softwaremill.sttp.client4:json-common_3:4.0.21`
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.19` from `4.0.19` to `4.0.21` under `com.softwaremill.sttp.client4:upickle_3:4.0.21`
 - Updated `com.softwaremill.sttp.client4:json-common_3:4.0.19` from `4.0.19` to `4.0.21` under `com.softwaremill.sttp.client4:upickle_3:4.0.21`

## Full dependency tree

 - org.scala-lang:toolkit_3:0.9.2
   - com.lihaoyi:os-lib_3:0.11.8
     - com.lihaoyi:geny_3:1.1.1
     - com.lihaoyi:os-zip:0.11.8
   - com.lihaoyi:upickle_3:4.4.3
     - com.lihaoyi:ujson_3:4.4.3
       - com.lihaoyi:upickle-core_3:4.4.3
         - com.lihaoyi:geny_3:1.1.1 (already listed)
     - com.lihaoyi:upack_3:4.4.3
       - com.lihaoyi:upickle-core_3:4.4.3 (already listed)
     - com.lihaoyi:upickle-implicits_3:4.4.3
       - com.lihaoyi:upickle-core_3:4.4.3 (already listed)
   - com.softwaremill.sttp.client4:core_3:4.0.21
     - com.softwaremill.sttp.model:core_3:1.7.17
     - com.softwaremill.sttp.shared:core_3:1.5.0
     - com.softwaremill.sttp.shared:ws_3:1.5.0
       - com.softwaremill.sttp.model:core_3:1.7.12
       - com.softwaremill.sttp.shared:core_3:1.5.0 (already listed)
   - com.softwaremill.sttp.client4:upickle_3:4.0.21
     - com.lihaoyi:upickle_3:4.4.1
       - com.lihaoyi:ujson_3:4.4.3 (already listed)
       - com.lihaoyi:upack_3:4.4.3 (already listed)
       - com.lihaoyi:upickle-implicits_3:4.4.3 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.21 (already listed)
     - com.softwaremill.sttp.client4:json-common_3:4.0.21
       - com.softwaremill.sttp.client4:core_3:4.0.21 (already listed)
