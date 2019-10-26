package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.baeldung.com/java-command-pattern
 * <p>
 * the pattern intends to encapsulate in an object all the data required for
 * performing a given action (command), including what method to call, the method's arguments, and the object to which the method belongs.
 * <p>
 * This model allows us to decouple objects that produce the commands from their consumers,
 * so that's why the pattern is commonly known as the producer-consumer pattern.
 */

public class Command {
    //In a classic implementation, the command pattern requires implementing four components: the Command, the Receiver, the Invoker, and the Client.

    // Command Classes
    @FunctionalInterface
    public interface TextFileOperation {
        String execute();
    }

    public class OpenTextFileOperation implements TextFileOperation {

        private TextFile textFile;

        // constructors

        @Override
        public String execute() {
            return textFile.open();
        }
    }

    public class SaveTextFileOperation implements TextFileOperation {
        private TextFile textFile;
        // same field and constructor as above

        @Override
        public String execute() {
            return textFile.save();
        }
    }

    //The Receiver Class
    //performs a set of cohesive actions

    public class TextFile {
        private String name;

        // constructor

//        TextFile(String file) {
//            this.name = file;
//        }

        public String open() {
            return "Opening file " + name;
        }

        public String save() {
            return "Saving file " + name;
        }
        // additional text file methods (editing, writing, copying, pasting)
    }

    //The Invoker Class
    //An invoker is an object that knows how to execute a given command but doesn't know how the command has been implemented.
    // It only knows the command's interface.
    public class TextFileOperationExecutor {

        private final List<TextFileOperation> textFileOperations
                = new ArrayList<>();

        public String executeOperation(TextFileOperation textFileOperation) {
            textFileOperations.add(textFileOperation);
            return textFileOperation.execute();
        }
        /*
         The TextFileOperationExecutor class is just a thin layer of abstraction that decouples the command objects
         from their consumers and calls the method encapsulated within the TextFileOperation command objects.
         In this case, the class also stores the command objects in a List.
         Of course, this is not mandatory in the pattern implementation, unless we need to add some further control to the operations' execution process.
         */
    }


    //The Client Class
    //A client is an object that controls the command execution process by specifying what commands to execute
    // and at what stages of the process to execute them.
    public static void main(String[] args) {
        Command c = new Command();

        TextFileOperationExecutor textFileOperationExecutor
                = c.new TextFileOperationExecutor();
//        textFileOperationExecutor.executeOperation(
//                c.new OpenTextFileOperation(c.new TextFile("file1.txt")));
//        textFileOperationExecutor.executeOperation(
//                c.new SaveTextFileOperation(c.new TextFile("file2.txt")));
    }

}



