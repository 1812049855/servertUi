package com.fhec.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {
    private static final Logger log = LoggerFactory.getLogger(Log.class);

    public static void Debug(String msg) {
        log.debug(msg);
    }

    public static void info(String msg)  {
        log.info(msg);
    }

    public static void error(String msg) {
        log.error(msg);
    }
}
