package ex456;

import java.util.EnumSet;

enum LogLevel {
    None,               //        0
    Info,               //        1
    Debug,              //       10
    Warning,            //      100
    Error,              //     1000
    FunctionalMessage,  //    10000
    FunctionalError;    //   100000

    //   111111
    public static EnumSet<LogLevel> All() {
        return EnumSet.of(
                LogLevel.None,
                LogLevel.Info,
                LogLevel.Debug,
                LogLevel.Warning,
                LogLevel.Error,
                LogLevel.FunctionalMessage,
                LogLevel.FunctionalError);
    }
}
