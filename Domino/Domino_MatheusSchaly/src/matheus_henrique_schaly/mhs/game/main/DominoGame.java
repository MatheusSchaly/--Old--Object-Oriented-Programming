package matheus_henrique_schaly.mhs.game.main;

import matheus_henrique_schaly.mhs.game.domino.view.UserIO;

/**
 * @author Matheus Schaly
 * Description: Creates and runs the UserIO class.
 */
public class DominoGame {

    /**
     * Runs the UserIO class.
     */
    public void run() {
        UserIO userIO = new UserIO();
        userIO.run();
    }
    
    /**
     * @param args the command line arguments, not used
     */
    public static void main(String[] args) {
        new DominoGame().run();
    }
    
}
