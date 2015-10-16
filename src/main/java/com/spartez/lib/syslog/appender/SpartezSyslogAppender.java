package com.spartez.lib.syslog.appender;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.impl.log4j.Syslog4jAppender;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogConfig;

public class SpartezSyslogAppender extends Syslog4jAppender {
    public static final String TCP_SSL_PROTOCOL = "tcp-ssl";

    public SpartezSyslogAppender() {
        Syslog.createInstance(TCP_SSL_PROTOCOL, new SSLTCPNetSyslogConfig());
    }

    public String initialize() {
        if (this.protocol == null) {
            this.protocol = TCP_SSL_PROTOCOL;
        }
        return this.protocol;
    }
}