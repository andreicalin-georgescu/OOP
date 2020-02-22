package ex456;

import java.util.EnumSet;

class ConsoleLogger extends LoggerBase {
    public ConsoleLogger(EnumSet<LogLevel> mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("[Console] " + msg);
    }
}
