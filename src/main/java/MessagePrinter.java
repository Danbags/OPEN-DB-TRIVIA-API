import java.util.Arrays;
//TO HELP FORMAT THE MESSAGES INTO THE BOX TO MAKE  IT EASIER ON THE USERS EYES SO THEY CAN KEEP TRACK OF WHAT IS BEING PRINTED/GOING ON
public class MessagePrinter {
    public void printMessage(String message, boolean printTop, boolean printBottom) {
        if (printTop) {
            System.out.println(
                    "x----------------------------------------------------------------------------------------------------x");
            System.out.print("|");
        } else {
            System.out.print("|");
        }

        boolean front = true;
        for (int i = message.length(); i < 100; i++) {
            if (front) {
                message = " " + message;
            } else {
                message = message + " ";
            }
            front = !front;
        }
        System.out.print(message);

        if (printBottom) {
            System.out.println("|");
            System.out.println(
                    "x----------------------------------------------------------------------------------------------------x");
        } else {
            System.out.println("|");
        }
    }

}
