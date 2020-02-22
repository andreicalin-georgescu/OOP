package bash;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

enum Commands {
    CD("cd"),
    LS("ls"),
    ECHO("echo"),
    HISTORY("history");

    private final String text;

    Commands(final String newText) {
        this.text = newText;
    }

    @Override
    public String toString() {
        return text;
    }
}

public class BashUtils {

    // Implement some inner classes here: Echo, Cd, Ls, History

    // example: class Cd { ... }

    // Decide if they should be static or non-static.

    // TODO 4 Create Echo class

    public static class Echo implements CommandSubscriber{
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().startsWith(Commands.ECHO.toString())) {
                System.out.println(c.getCommand().substring(5, c.getCommand().length()));
            }
        }
    }

    // TODO 5 Create Cd class

    public static class Cd implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().startsWith(Commands.CD.toString())) {
                c.getBash().setCurrentDirectory(Paths.get(
                        c.getBash().getCurrentDirectory().toString(),
                        c.getCommand().substring(3, c.getCommand().length())).toAbsolutePath());
            }
            }
    }


    // TODO 6 Create the Ls class

    public static class Ls implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            if (c.getCommand().startsWith(Commands.LS.toString())) {
                listDirContents(c.getBash().getCurrentDirectory());
            }
        }

        private void listDirContents(Path dirPath) {
            File folder = dirPath.toFile();
            File[] listOfFiles = folder.listFiles();

            System.out.println(dirPath);

            for (File file : listOfFiles) {
                System.out.println(file.getName());
            }
        }
    }
    // TODO 7 Create the History class

    public static class History implements CommandSubscriber {
        @Override
        public void executeCommand(Command c) {
            c.getBash().getHistory().append(c.getCommand());
            c.getBash().getHistory().append(" | ");

            if (c.getCommand().startsWith(Commands.HISTORY.toString())) {
                System.out.println("History is: " + c.getBash().getHistory());
            }
        }
    }
}
