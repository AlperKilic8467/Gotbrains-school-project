package gotBrains;

/**
 * Class used in testing the highscore system.
 * @author Isak Hartman
 *
 */
public class HighscoreTest {
    public static void main(String[] args) {
        HighscoreManager hm = new HighscoreManager();
//        hm.clearScores();
        hm.addPlayer("Isak");
        hm.addPlayer("Felix");
        hm.addPlayer("Gulcin");
        hm.addPlayer("Farid");
        hm.addPlayer("Alper");
        
        hm.addCalculateThisScore("Isak", 10);
        hm.addSpellThisScore("Isak", 12);
        hm.addMemorizeThisScore("Isak", 8);
        
        hm.addCalculateThisScore("Felix", 14);
        hm.addSpellThisScore("Felix", 4);
        hm.addMemorizeThisScore("Felix", 6);
        
        hm.addCalculateThisScore("Gulcin", 10);
        hm.addSpellThisScore("Gulcin", 5);
        hm.addMemorizeThisScore("Gulcin", 5);
        
        hm.addCalculateThisScore("Alper", 2);
        hm.addSpellThisScore("Alper", 5);
        hm.addMemorizeThisScore("Alper", 10);
        
        
        hm.addCalculateThisScore("Unknown", 1);
        hm.addSpellThisScore("Unknown", 1);
        hm.addMemorizeThisScore("Unknown", 1);
        
        hm.addPlayer("Unknown");
        
        hm.updateScoreFile();
        hm.loadScoreFile();
        System.out.print(hm.getLeaderboardPlacement());
        System.out.println();
        
        hm.addPlayer("Isak");
        hm.addCalculateThisScore("Isak", 20);
        hm.addSpellThisScore("Isak", 24);
        hm.addMemorizeThisScore("Isak", 16);
        
//        hm.addMathGameScore("Unknown", 1);
//        hm.addScrabbleScore("Unknown", 1);
//        hm.addSimonSaysScore("Unknown", 1);
//        hm.clearScores();
        hm.updateScoreFile();
        hm.loadScoreFile();
        System.out.print(hm.getLeaderboardPlacement());
        System.out.println();
    }
}