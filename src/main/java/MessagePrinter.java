import java.util.Arrays;
/**
 * This class represents a printer for formatting and printing messages.
 * It provides a method for printing messages in a formatted box.
 */
public class MessagePrinter {
     /**
       * Prints a message in a formatted box.
       * 
       * @param message The message to print.
       * @param printTop Whether to print the top border of the box.
       * @param printBottom Whether to print the bottom border of the box.
       */
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
