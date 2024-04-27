package org.example.sudokufinal.model;

public interface ISudoku {
   // Resets the Sudoku game to its initial state.
    void resetGame();
    //Checks if the Sudoku puzzle is complete.
    boolean isSudokuComplete();
    /**
     * Sets a number in the Sudoku puzzle table at the specified row and column.
     * @param number The number to set.
     * @param row    The row index.
     * @param col    The column index.
     */
    void setNumberInTableSodoku(int number, int row, int col);
}
