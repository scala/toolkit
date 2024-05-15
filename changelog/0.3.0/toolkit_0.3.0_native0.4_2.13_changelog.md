# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:os-lib_native0.4_2.13:0.9.1` from `0.9.1` to `0.9.3` under `org.scala-lang:toolkit_native0.4_2.13:0.3.0`
 - Updated `com.lihaoyi:upickle_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `org.scala-lang:toolkit_native0.4_2.13:0.3.0`
 - Updated `com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `org.scala-lang:toolkit_native0.4_2.13:0.3.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `org.scala-lang:toolkit_native0.4_2.13:0.3.0` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_native0.4_2.13:3.1.4`
 - Updated `com.lihaoyi:ujson_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_native0.4_2.13:3.2.0`
 - Updated `com.lihaoyi:upack_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_native0.4_2.13:3.1.4`
 - Updated `com.lihaoyi:upack_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_native0.4_2.13:3.2.0`
 - Updated `com.lihaoyi:upickle-core_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:ujson_native0.4_2.13:3.2.0`
 - Updated `com.lihaoyi:upickle-core_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upack_native0.4_2.13:3.2.0`
 - Updated `com.lihaoyi:upickle-core_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle-implicits_native0.4_2.13:3.2.0`
 - Updated `com.lihaoyi:upickle-implicits_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_native0.4_2.13:3.1.4`
 - Updated `com.lihaoyi:upickle-implicits_native0.4_2.13:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_native0.4_2.13:3.2.0`
 - Updated `com.lihaoyi:upickle_native0.4_2.13:3.1.3` from `3.1.3` to `3.1.4` under `com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M12`
 - Updated `com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `com.softwaremill.sttp.client4:json-common_native0.4_2.13:4.0.0-M12` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M12` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_native0.4_2.13:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M12` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_native0.4_2.13:1.7.2` from `1.7.2` to `1.7.9` under `com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M12`
 - Updated `com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M12`
 - Updated `com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.shared:ws_native0.4_2.13:1.3.17`
 - Updated `com.softwaremill.sttp.shared:ws_native0.4_2.13:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M12`

## Full dependency tree

 - org.scala-lang:toolkit_native0.4_2.13:0.3.0
   - com.lihaoyi:os-lib_native0.4_2.13:0.9.3
     - com.lihaoyi:geny_native0.4_2.13:1.0.0
   - com.lihaoyi:upickle_native0.4_2.13:3.2.0
     - com.lihaoyi:ujson_native0.4_2.13:3.2.0
       - com.lihaoyi:upickle-core_native0.4_2.13:3.2.0
         - com.lihaoyi:geny_native0.4_2.13:1.0.0 (already listed)
     - com.lihaoyi:upack_native0.4_2.13:3.2.0
       - com.lihaoyi:upickle-core_native0.4_2.13:3.2.0 (already listed)
     - com.lihaoyi:upickle-implicits_native0.4_2.13:3.2.0
       - com.lihaoyi:upickle-core_native0.4_2.13:3.2.0 (already listed)
   - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M12
     - com.softwaremill.sttp.model:core_native0.4_2.13:1.7.9
     - com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.17
     - com.softwaremill.sttp.shared:ws_native0.4_2.13:1.3.17
       - com.softwaremill.sttp.model:core_native0.4_2.13:1.6.0
       - com.softwaremill.sttp.shared:core_native0.4_2.13:1.3.17 (already listed)
   - com.softwaremill.sttp.client4:upickle_native0.4_2.13:4.0.0-M12
     - com.lihaoyi:upickle_native0.4_2.13:3.1.4
       - com.lihaoyi:ujson_native0.4_2.13:3.2.0 (already listed)
       - com.lihaoyi:upack_native0.4_2.13:3.2.0 (already listed)
       - com.lihaoyi:upickle-implicits_native0.4_2.13:3.2.0 (already listed)
     - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M12 (already listed)
     - com.softwaremill.sttp.client4:json-common_native0.4_2.13:4.0.0-M12
       - com.softwaremill.sttp.client4:core_native0.4_2.13:4.0.0-M12 (already listed)
