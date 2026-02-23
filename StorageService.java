import java.io.*;

public class StorageService {
    public static void storeResult(String player, int attempts, boolean win) {
        String line = "Player: " + player + ", Attempts: " + attempts + ", Result: " + (win ? "WIN" : "LOSE");
        
        System.out.println(line);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_results.txt", true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Unable to save game result.");
        }
    }
}