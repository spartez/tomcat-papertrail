package com.spartez.lib.syslog.appender;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Enumeration;

public class SpartezSyslogAppenderTest {
    @Test
    public void testAppenderIsConfigurable() {
        PropertyConfigurator.configure(SpartezSyslogAppenderTest.class.getResource("/com/spartez/lib/syslog/appender/log4j.properties"));
        final Logger log = Logger.getLogger(SpartezSyslogAppender.class);
        log.info("Log4j configured successfully");
        final Enumeration allAppenders = log.getLoggerRepository().getRootLogger().getAllAppenders();
        Assert.assertTrue(allAppenders.hasMoreElements());
        final Object appender = allAppenders.nextElement();
        Assert.assertEquals(SpartezSyslogAppender.class.getName(), appender.getClass().getName());
    }
}
