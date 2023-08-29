import java.util.Scanner;


public class NumberPuzzleG {
    private NumberPuzzleBoard b;
    private Scanner scanner;
    private Level[] levels;
    private int curLevIndex;
    private InputR inputR;
    private PuzzleTimer timer; 
    private int moves;
        

    public NumberPuzzleG(Level[] levels) {
        this.levels = levels;
        this.curLevIndex = 0;
        this.b = null;
        this.scanner = new Scanner(System.in);
        this.inputR = new InputR();
        this.timer = new PuzzleTimer();
        this.moves = 0; 
        
    }

    public void showMenu() {
        System.out.println("Welcome to Number Puzzle Game!");
        System.out.println("Choose a level:");
        for (int i = 0; i < levels.length; i++) {
            System.out.println((i + 1) + ". Level " + (i + 1) + " (" + levels[i].getGridSize() + "x" + levels[i].getGridSize() + ")");
        }
        System.out.print("Enter the level number: ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= levels.length) {
           
            b = new NumberPuzzleBoard(levels[choice - 1].getGridSize());
        } else {
            System.out.println("Invalid choice. Please select a valid level.");
            showMenu(); 
        }
    }
    public void displayMoves() {
        System.out.println("Number of Moves: " + moves);
        
    }
    public int[] start() {
        int[] scores = new int[levels.length];
        while (curLevIndex < levels.length) {
            Level currentLevel = levels[b.getBoard().length - 2];
            int gridSize = currentLevel.getGridSize(); 
            b = new NumberPuzzleBoard(gridSize); 
            b.initialize(currentLevel.getInitialGrid());
            b.shuffle();
            timer.startTimer(); 
            moves = 0;
            while (!b.isSolved()) {
                int[][] crntBoard = b.getBoard();
                b.displayLevel(crntBoard);
                String mv = inputR.getValidMove();
                b.move(mv);
                moves++; 
            }
    
            timer.stopTimer(); 
            int eSecond = timer.getsecondE();
    
            System.out.println("Level " + (curLevIndex + 1) + " completed in " + eSecond + " seconds.");
            System.out.println("Number of Moves: " + moves);
           
        int score = calScore(moves);

        scores[curLevIndex] = score; 

        System.out.println("Score for Level " + (curLevIndex + 1) + ": " + score);

    
            if (curLevIndex < levels.length - 1) {
                System.out.println("Next Level...");
            }
    
            curLevIndex++; 
        }
    
        System.out.println("Congratulations! You completed all levels.");
        return scores; 
    }
    private int calScore(int moves) {
    
        return 100 - moves;
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        
        Level[] levels = {
            new Level(2,
                new int[][] {{1, 2}, {3, 0}}, 
                new int[][] {{1, 2}, {3, 0}} 
            ),
            new Level(3, 
                new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}, 
                new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}} 
            ),
            new Level(4, 
                new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}},
                new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}} 
            ),
           
        };   
        NumberPuzzleG game = new NumberPuzzleG(levels);
        game.showMenu();
        game.start();
    }
}