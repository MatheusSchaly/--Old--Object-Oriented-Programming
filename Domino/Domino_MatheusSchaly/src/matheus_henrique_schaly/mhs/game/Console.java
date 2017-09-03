package matheus_henrique_schaly.mhs.game;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Matheus Schaly
 * Description: Validates user's input.
 */
public class Console {
    
    /**
     * File to read directly from the console.
     */
    private final static Scanner input = new Scanner(System.in);
    
    /**
     * Reads a string from console.
     * 
     * @param question String to be shown at console
     * @return String read from console
     */
    public static String readString(String question) {
        System.out.println(question);
        return input.next();
    }
    
    /**
     * Reads a int from console, that is within a interval
     * 
     * @param question String to be shown at console
     * @param min Lowest value from interval
     * @param max Highest value from interval
     * @return Int read from console
     */
    public static int readIntInterval(String question, int min, int max) {
        boolean validAnswer; 
        int answer = 0;
        do {
            try {
                System.out.println(question + "(" + min + " to " + max + ")");
                answer = input.nextInt();
                validAnswer = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("You must enter a number.");
                validAnswer = false;
            }
        } while (!validAnswer || (answer < min || answer > max));
        return answer;
    }
    
    /**
     * Asks for a yes or no answer from console.
     * 
     * @param question String to be shown at console
     * @return True if answer is yes
     */
    public static boolean askYesNo(String question) {
        System.out.println(question + "(y/n)");
        String answer;
        do {
            answer = input.next();
            if (answer.equals("y")) {
                return true;
            }
            else if (answer.equals("n")) {
                return false;
            }
            else {
                System.out.println("Choose between y or n.");
            }
        } while (true);
    }
    
}
