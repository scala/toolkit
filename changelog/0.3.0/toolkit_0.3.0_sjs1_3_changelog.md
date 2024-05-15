# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:upickle_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `org.scala-lang:toolkit_sjs1_3:0.3.0`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `org.scala-lang:toolkit_sjs1_3:0.3.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `org.scala-lang:toolkit_sjs1_3:0.3.0` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_sjs1_3:3.1.4`
 - Updated `com.lihaoyi:ujson_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_sjs1_3:3.2.0`
 - Updated `com.lihaoyi:upack_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_sjs1_3:3.1.4`
 - Updated `com.lihaoyi:upack_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_sjs1_3:3.2.0`
 - Updated `com.lihaoyi:upickle-core_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:ujson_sjs1_3:3.2.0`
 - Updated `com.lihaoyi:upickle-core_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upack_sjs1_3:3.2.0`
 - Updated `com.lihaoyi:upickle-core_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle-implicits_sjs1_3:3.2.0`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_sjs1_3:3.1.4`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_3:3.1.3` from `3.1.3` to `3.2.0` under `com.lihaoyi:upickle_sjs1_3:3.2.0`
 - Updated `com.lihaoyi:upickle_sjs1_3:3.1.3` from `3.1.3` to `3.1.4` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M12`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.0-M12` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M12` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.0-M6` from `4.0.0-M6` to `4.0.0-M12` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M12` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_sjs1_3:1.7.2` from `1.7.2` to `1.7.9` under `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M12`
 - Updated `com.softwaremill.sttp.shared:core_sjs1_3:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M12`
 - Updated `com.softwaremill.sttp.shared:core_sjs1_3:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.shared:ws_sjs1_3:1.3.17`
 - Updated `com.softwaremill.sttp.shared:ws_sjs1_3:1.3.16` from `1.3.16` to `1.3.17` under `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M12`

## Full dependency tree

 - org.scala-lang:toolkit_sjs1_3:0.3.0
   - com.lihaoyi:upickle_sjs1_3:3.2.0
     - com.lihaoyi:ujson_sjs1_3:3.2.0
       - com.lihaoyi:upickle-core_sjs1_3:3.2.0
         - com.lihaoyi:geny_sjs1_3:1.0.0
     - com.lihaoyi:upack_sjs1_3:3.2.0
       - com.lihaoyi:upickle-core_sjs1_3:3.2.0 (already listed)
     - com.lihaoyi:upickle-implicits_sjs1_3:3.2.0
       - com.lihaoyi:upickle-core_sjs1_3:3.2.0 (already listed)
   - com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M12
     - com.softwaremill.sttp.model:core_sjs1_3:1.7.9
       - io.github.cquiroz:scala-java-time_sjs1_3:2.5.0
         - io.github.cquiroz:scala-java-locales_sjs1_3:1.5.1
           - io.github.cquiroz:cldr-api_sjs1_3:4.0.0
             - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2
         - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2 (already listed)
     - com.softwaremill.sttp.shared:core_sjs1_3:1.3.17
     - com.softwaremill.sttp.shared:ws_sjs1_3:1.3.17
       - com.softwaremill.sttp.model:core_sjs1_3:1.6.0
         - io.github.cquiroz:scala-java-time_sjs1_3:2.5.0 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_3:1.3.17 (already listed)
   - com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M12
     - com.lihaoyi:upickle_sjs1_3:3.1.4
       - com.lihaoyi:ujson_sjs1_3:3.2.0 (already listed)
       - com.lihaoyi:upack_sjs1_3:3.2.0 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_3:3.2.0 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M12 (already listed)
     - com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.0-M12
       - com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M12 (already listed)
