public class Level {
    private int gridSize; 

    private int[][] initialGrid;
    private int[][] solutionGrid;

    public Level(int gridSize, int[][] initialGrid, int[][] solutionGrid) {
        this.gridSize = gridSize;
        this.initialGrid = initialGrid;
        this.solutionGrid = solutionGrid;
    }

    public int getGridSize() { 
        return gridSize;
    }

    public int[][] getInitialGrid() {
        return initialGrid;
    }

    public int[][] getSolutionGrid() {
        return solutionGrid;
    }

   
}