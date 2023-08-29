public class NumberPuzzleBoard {

    private int[][] board;
    private final int s;
    private int emptyR;
    private int emptyC;
    private boolean isShuffled;
    private int moves;

    public NumberPuzzleBoard(int s) {
        this.s = s;
        this.board = new int[s][s];
    }
    public int[][] getBoard() {
        return board;
    }
    //

    public void initialize(int[][] initialGrid) {
        for (int r = 0; r < s; r++) {
            for (int c = 0; c < s; c++) {
                board[r][c] = initialGrid[r][c];
                if (board[r][c] == 0) {
                    emptyR = r;
                    emptyC = c;
                }
            }
        }
    }
    public void shuffle() {
        if (isShuffled) {
            System.out.println("The puzzle board has already been shuffled.");
            return;
        }
    
      
        String[] moves = {"u", "d", "l", "r"};
    
        int shuffleCount = s * s * 100;
        while (shuffleCount > 0) {
            int randInd = (int) (Math.random() * 4); 
            String randMov = moves[randInd]; 
    
            
            if (randMov.equals("u") && emptyR > 0) {
                swap(emptyR, emptyC, emptyR - 1, emptyC);
                emptyR--;
            } else if (randMov.equals("d") && emptyR < s - 1) {
                swap(emptyR, emptyC, emptyR + 1, emptyC);
                emptyR++;
            } else if (randMov.equals("l") && emptyC > 0) {
                swap(emptyR, emptyC, emptyR, emptyC - 1);
                emptyC--;
            } else if (randMov.equals("r") && emptyC < s - 1) {
                swap(emptyR, emptyC, emptyR, emptyC + 1);
                emptyC++;
            }
            shuffleCount--;
        }
    
        isShuffled = true;
    }
    



    public void move(String move) {
        if (move.equals("u") && emptyR > 0) {
            swap(emptyR, emptyC, emptyR - 1, emptyC);
            emptyR--;
            moves++; // Increment moves
        } else if (move.equals("r") && emptyC < s - 1) {
            swap(emptyR, emptyC, emptyR, emptyC + 1);
            emptyC++;
            moves++; // Increment moves
        } else if (move.equals("d") && emptyR < s - 1) {
            swap(emptyR, emptyC, emptyR + 1, emptyC);
            emptyR++;
            moves++; // Increment moves
        } else if (move.equals("l") && emptyC > 0) {
            swap(emptyR, emptyC, emptyR, emptyC - 1);
            emptyC--;
            moves++; // Increment moves
        }
    }
    

    private void swap(int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    public boolean isSolved() {
        int count = 1;
        for (int r = 0; r < s; r++) {
            for (int c = 0; c < s; c++) {
                if (r == s - 1 && c == s - 1) {
                    if (board[r][c] != 0) {
                        return false;
                    }
                } else {
                    if (board[r][c] != count) {
                        return false;
                    }
                    count++;
                }
            }
        }
        return true;
    }

    public void displayLevel(int[][] grid) {
        for (int[] r : grid) {
            for (int num : r) {
                if (num == 0) {
                    System.out.print("  "); 
                } else {
                    System.out.print(num + " ");
                }
            }
            System.out.println(); 
        }
        System.out.println(); 
    }
    
}