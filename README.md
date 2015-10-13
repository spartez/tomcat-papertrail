# README #

This library is simple extension to the org.syslog4j.syslog4. It binds the SSLTCP config implementation to the "tcp-ssl" protocol type.

## Usage ##

1. Copy the jar file to the tomcat lib folder (or to any folder which is on the tomcat's CLASSPATH)
2. Copy original syslog4j-0.9.46.jar lib to the same folder.
3. Change log4j.properties (probably you find it inside /WEB-INF/classes folder)

## Example of ##


```
#!properties

log4j.appender.syslog4j=com.spartez.lib.syslog.appender.SpartezSyslogApender
log4j.appender.syslog4j.Facility=LOCAL7
log4j.appender.syslog4j.Host=logs3.papertrailapp.com
log4j.appender.syslog4j.Port=12696
log4j.appender.syslog4j.Protocol=tcp-ssl
log4j.appender.syslog4j.layout=org.apache.log4j.PatternLayout
log4j.appender.syslog4j.layout.ConversionPattern=%p: (%F:%L) %x %m %n
```
 