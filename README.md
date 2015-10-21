# How to set up Papertrail logging in Tomcat #

This library is a simple extension to the org.syslog4j.syslog4 that will allow you to use syslog4 in Tomcat with Papertrail over SSL.

## Instructions ##

**SSL support:**

1. Download papertail .pem file (http://help.papertrailapp.com/kb/configuration/encrypting-remote-syslog-with-tls-ssl/).
2. Add the cert file to the JVM key store.


```
sudo keytool -import -alias papertrail -file papertrail.crt -keystore ${JAVA_HOME}/jre/lib/security/cacerts
```

 
**Tomcat configuration:**

Run `mvn package` to create JAR file and download an additional [syslog4j library](http://syslog4j.org).

1. Copy the jar file to the tomcat lib folder (or to any folder which is on the tomcat's CLASSPATH)
2. Copy original syslog4j-0.9.46.jar lib to the same folder.
3. Change log4j.properties (probably you find it inside /WEB-INF/classes folder)

## Example of log4.properties config ##


```
log4j.appender.syslog4j=com.spartez.lib.syslog.appender.SpartezSyslogApender
log4j.appender.syslog4j.Facility=LOCAL7
log4j.appender.syslog4j.Host=logs3.papertrailapp.com
log4j.appender.syslog4j.Port=12696
log4j.appender.syslog4j.Protocol=tcp-ssl
log4j.appender.syslog4j.Layout=org.apache.log4j.PatternLayout
log4j.appender.syslog4j.Layout.ConversionPattern=%p: (%F:%L) %x %m %n
```

remember to add the new appender to the rootLogger config


```
log4j.rootLogger=WARN, console, filelog, syslog4j
```

## Notice ##

This appender seems to be pretty slow. It's not appropriate to use it with log level less than **WARN**, or with a very verbose system. If it becomes too slow, I recommend to fix this appender (https://github.com/mrapczynski/log4j-papertrail-appender).
