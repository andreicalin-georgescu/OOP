package ex456;

import java.util.EnumSet;

abstract class LoggerBase {
    protected EnumSet<LogLevel> logMask;
    protected LoggerBase next;

    public LoggerBase(EnumSet<LogLevel> mask) {
        this.logMask = mask;
    }

    public LoggerBase setNext(LoggerBase nextlogger) {
        next = nextlogger;
        return nextlogger;
    }

    public void message(String msg, LogLevel severity) {
        if (logMask.contains(severity)) {
            writeMessage(msg);
        }

		if (next != null) {
            next.message(msg, severity);
        }
    }

    abstract protected void writeMessage(String msg);
}
