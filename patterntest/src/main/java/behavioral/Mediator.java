package behavioral;

import java.util.Date;

/**
 * https://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
 * Mediator pattern is used to reduce communication complexity between multiple objects or classes.
 */
public class Mediator {

    //Create mediator class.
    public static class ChatRoom {
        public static void showMessage(User user, String message) {
            System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
        }
    }

    //Create user class
    public class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String name) {
            this.name = name;
        }

        public void sendMessage(String message) {
            ChatRoom.showMessage(this, message);
        }
    }

    //Use the User object to show communications between them.
    public static void main(String[] args) {
        Mediator m = new Mediator();

        User robert = m.new User("Robert");
        User john = m.new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
