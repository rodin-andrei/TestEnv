package in.arod.testEnv.core.logging;

import org.apache.log4j.Logger;



public class Log4j {
    private static Logger log = Logger.getLogger(Log4j.class);

    public void log() {
        log.info("log4j info level");
    }
}
