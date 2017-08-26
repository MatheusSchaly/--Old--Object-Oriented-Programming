package matheus_henrique_schaly.mhs.game;

import java.util.Scanner;

/**
 *
 * @author hsmatheus
 */
public class Console {
    
    public static String readString (String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    
    public static int readInt (String question) {
        System.out.println(question);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
    
}
