package in.arod.testEnv.core.logging;



public class Program {
    public static void main(String[] args) {
        new JavaLogging().log();
        new Log4j().log();
        new Log4j2().log();
        new Logback().log();
        new SystemOut().log();
    }
}
