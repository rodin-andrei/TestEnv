package in.arod.testEnv.core.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logback {


    private Logger log = LoggerFactory.getLogger(Logback.class);


    public void log() {
        log.info("logback info");
    }
}
