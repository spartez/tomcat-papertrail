package com.spartez.lib.syslog.appender;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.impl.log4j.Syslog4jAppender;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogConfig;

public class SpartezSyslogApender extends Syslog4jAppender {
    public SpartezSyslogApender() {
        Syslog.createInstance("tcp-ssl", new SSLTCPNetSyslogConfig());
    }
}