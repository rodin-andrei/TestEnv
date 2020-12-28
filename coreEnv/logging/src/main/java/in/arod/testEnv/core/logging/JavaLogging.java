package in.arod.testEnv.core.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaLogging {
    private final static Logger LOGGER = Logger.getLogger(JavaLogging.class.getName());

    public void log() {
        LOGGER.log(Level.INFO, "java info log");
    }
}
