package ex456;

import java.util.EnumSet;

class FileLogger extends LoggerBase {
    public FileLogger  (EnumSet<LogLevel> mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("[File] " + msg);
    }
}
