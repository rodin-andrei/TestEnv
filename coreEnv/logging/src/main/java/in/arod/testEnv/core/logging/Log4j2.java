package in.arod.testEnv.core.logging;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log4j2 {
    private static final Logger log = LogManager.getLogger(Log4j2.class);

    public void log() {
        log.info("log4j2 info level");
    }
}
