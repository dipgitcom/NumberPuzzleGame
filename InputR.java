import java.util.Scanner;

public class InputR {
    private Scanner scanner;

    public InputR() {
        scanner = new Scanner(System.in);
    }

    public String getValidMove() {
        String input;
        while (true) {
            System.out.print("Enter a move (u/d/l/r):");
            input = scanner.nextLine().toLowerCase(); 
            
            if (isValidMove(input)) {
                return input;
            } else {
                System.out.println("Invalid move. Please enter 'up', 'down', 'left', or 'right'.");
            }
        }
    }

    private boolean isValidMove(String move) {
        return move.equals("u") || move.equals("d") || move.equals("l") || move.equals("r");
    }
}