package org.example.sudokufinal.model;

/**Class that represents a Sudoku game.*/
public class Sudoku implements ISudoku {
    private int[][] tableSudoku;
    private final int[][] tableSudokuSolution;

    /** Constructor that initializes a new Sudoku game with the default board and solution.
     */
    public Sudoku()
    // Initialize the Sudoku board and its solution
    {
        this.tableSudoku = new int[][]{
                {5,3,0,0,7,0,0,1,0},
                {6,0,0,1,9,5,0,4,0},
                {0,9,0,0,0,0,0,6,7},
                {8,0,0,0,6,0,4,0,3},
                {4,0,6,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {2,0,0,4,1,9,0,0,5},
                {3,0,5,0,8,0,0,7,0}
        };
        this.tableSudokuSolution = new int[][]{
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };
    }

    /**
     * Check if the Sudoku is complete.
     * @return true if the Sudoku is complete, false otherwise.
     */
    public boolean isSudokuComplete() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tableSudoku[i][j] != tableSudokuSolution[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Resets the Sudoku game, resetting the board to the initial state.
     */
    public void resetGame() {
        this.tableSudoku = new int[][]{
                {5,3,0,0,7,0,0,1,0},
                {6,0,0,1,9,5,0,4,0},
                {0,9,0,0,0,0,0,6,7},
                {8,0,0,0,6,0,4,0,3},
                {4,0,6,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {2,0,0,4,1,9,0,0,5},
                {3,0,5,0,8,0,0,7,0}
        };
    }

    /**
     * Set a number in a specific cell of the Sudoku board.
     * @param number The number to set in the cell.
     * @param row The row of the cell.
     * @param col The column of the cell.
     */
    @Override
    public void setNumberInTableSodoku(int number, int row, int col) {
        this.tableSudoku[row][col] = number;
        // Set the number in the specific cell of the Sudoku board
    }
    /**
     * Gets the current Sudoku board.
     * @return The current Sudoku board.
     */
    public int[][] getTableSudoku() {
        return tableSudoku;
        // Returns the current Sudoku board
    }
}