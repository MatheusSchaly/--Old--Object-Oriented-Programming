package matheus_henrique_schaly.mhs.game;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author hsmatheus
 */
public class Console {
    
    private final static Scanner input = new Scanner(System.in);
    
    public static String readString(String question) {
        System.out.println(question);
        return input.next();
    }
    
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
