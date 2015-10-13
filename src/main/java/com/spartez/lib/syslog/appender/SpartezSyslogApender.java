package com.spartez.lib.syslog.appender;

import org.apache.log4j.Appender;
import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.impl.log4j.Syslog4jAppender;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogConfig;

public class SpartezSyslogApender extends Syslog4jAppender implements Appender {
    public SpartezSyslogApender() {
        Syslog.createInstance("tcp-ssl", new SSLTCPNetSyslogConfig());
    }
}