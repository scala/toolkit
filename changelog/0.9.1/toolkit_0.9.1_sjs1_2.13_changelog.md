# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:upickle_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `org.scala-lang:toolkit_sjs1_2.13:0.9.1`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.15` from `4.0.15` to `4.0.19` under `org.scala-lang:toolkit_sjs1_2.13:0.9.1`
 - Updated `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.15` from `4.0.15` to `4.0.19` under `org.scala-lang:toolkit_sjs1_2.13:0.9.1`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle_sjs1_2.13:4.4.3`
 - Updated `com.lihaoyi:upack_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle_sjs1_2.13:4.4.3`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:ujson_sjs1_2.13:4.4.3`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upack_sjs1_2.13:4.4.3`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle-implicits_sjs1_2.13:4.4.3`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_2.13:4.4.2` from `4.4.2` to `4.4.3` under `com.lihaoyi:upickle_sjs1_2.13:4.4.3`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.15` from `4.0.15` to `4.0.19` under `com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.19`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.15` from `4.0.15` to `4.0.19` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.19`
 - Updated `com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.15` from `4.0.15` to `4.0.19` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.19`

## Full dependency tree

 - org.scala-lang:toolkit_sjs1_2.13:0.9.1
   - com.lihaoyi:upickle_sjs1_2.13:4.4.3
     - com.lihaoyi:ujson_sjs1_2.13:4.4.3
       - com.lihaoyi:upickle-core_sjs1_2.13:4.4.3
         - com.lihaoyi:geny_sjs1_2.13:1.1.1
     - com.lihaoyi:upack_sjs1_2.13:4.4.3
       - com.lihaoyi:upickle-core_sjs1_2.13:4.4.3 (already listed)
     - com.lihaoyi:upickle-implicits_sjs1_2.13:4.4.3
       - com.lihaoyi:upickle-core_sjs1_2.13:4.4.3 (already listed)
   - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.19
     - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.17
       - io.github.cquiroz:scala-java-time_sjs1_2.13:2.6.0
         - io.github.cquiroz:scala-java-locales_sjs1_2.13:1.5.4
           - io.github.cquiroz:cldr-api_sjs1_2.13:4.5.0
             - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.3
         - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.3 (already listed)
     - com.softwaremill.sttp.shared:core_sjs1_2.13:1.5.0
     - com.softwaremill.sttp.shared:ws_sjs1_2.13:1.5.0
       - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.12
         - io.github.cquiroz:scala-java-time_sjs1_2.13:2.6.0 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_2.13:1.5.0 (already listed)
   - com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.19
     - com.lihaoyi:upickle_sjs1_2.13:4.4.1
       - com.lihaoyi:ujson_sjs1_2.13:4.4.3 (already listed)
       - com.lihaoyi:upack_sjs1_2.13:4.4.3 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_2.13:4.4.3 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.19 (already listed)
     - com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.19
       - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.19 (already listed)
