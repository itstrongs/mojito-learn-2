package com.mojito.learn.design.patterns;

/**
 * 责任链模式
 *
 * @author liufengqiang
 * @date 2021-05-19 18:31:55
 */
public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "info 日志");
        loggerChain.logMessage(AbstractLogger.DEBUG, "debug 日志");
        loggerChain.logMessage(AbstractLogger.ERROR, "error 日志");
    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static class ConsoleLogger extends AbstractLogger {

        public ConsoleLogger(int level) {
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("Standard Console::Logger: " + message);
        }
    }

    public static class ErrorLogger extends AbstractLogger {

        public ErrorLogger(int level) {
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("Error Console::Logger: " + message);
        }
    }

    public static class FileLogger extends AbstractLogger {

        public FileLogger(int level) {
            this.level = level;
        }

        @Override
        protected void write(String message) {
            System.out.println("File::Logger: " + message);
        }
    }

    public static abstract class AbstractLogger {

        public static int INFO = 1;
        public static int DEBUG = 2;
        public static int ERROR = 3;
        protected int level;

        //责任链中的下一个元素
        protected AbstractLogger nextLogger;

        public void setNextLogger(AbstractLogger nextLogger) {
            this.nextLogger = nextLogger;
        }

        public void logMessage(int level, String message) {
            if (this.level <= level) {
                write(message);
            }
            if (nextLogger != null) {
                nextLogger.logMessage(level, message);
            }
        }

        abstract protected void write(String message);
    }
}
