package ex456;

import java.util.EnumSet;

class EmailLogger extends LoggerBase {
    public EmailLogger (EnumSet<LogLevel> mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("[Email] " + msg);
    }
}
