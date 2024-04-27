package org.example.sudokufinal.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.sudokufinal.model.Sudoku;

public class SudokuGameController {
    @FXML
    private GridPane tableSudokuGridPane;
    private Sudoku sudoku;

    @FXML
    /*
    Method to initialize the graphical user interface for the Sudoku game.
     This method is automatically executed when the corresponding view is loaded.
     */
    public void initialize() {
        // Create a new instance of Sudoku to manage the game.
        sudoku = new Sudoku();
        /*
        Iterate through the 9x9 matrix of the Sudoku board to
        generate the corresponding text fields.
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Create a new text field for each cell of the Sudoku board.
                TextField txt = new TextField();
                txt.setPrefHeight(56);
                txt.setPrefWidth(56);
                txt.setAlignment(Pos.CENTER);
                if (j == 2 || j == 5) {
                    txt.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                            BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, new BorderWidths(1.0, 3.0, i == 2|| i==5? 3.0 : 1.0, 1.0), Insets.EMPTY)));
                }
                // Define the borders for rows 2 and 5 with a different thickness on the lower side
                else if (i == 2 || i == 5) {
                    txt.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                            BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, new BorderWidths(1.0 , j == 2|| j==5? 3.0 : 1.0, 3.0, 1.0), Insets.EMPTY)));
                }
                // standard form of rows and columns
                else {
                    txt.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
                }

                /*
                Set the value of the text field according to the value of the
                corresponding cell in the Sudoku board.
                 */
                txt.setText(String.valueOf(sudoku.getTableSudoku()[i][j]));
                // If the value of the cell in the Sudoku board is greater than 0, set it as not editable and change the background of the text field.
                if (sudoku.getTableSudoku()[i][j] > 0) {
                    txt.setEditable(false);
                    txt.setBackground(new Background(new BackgroundFill(Color.rgb(232, 186, 186), null, null)));
                }
                // If the value of the cell is 0, leave the text field editable and set a white background.
                else {
                    txt.setText("");
                    txt.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                    onKeyPressed(txt, i, j); // Llama al método onKeyPressed aquí
                }
                tableSudokuGridPane.add(txt, j, i);
            }
        }
    }

    @FXML
    //This method is responsible for verifying that the sudoku is correct
    public void check() {
        System.out.println("Check");
        if (sudoku.isSudokuComplete()) {
            System.out.println("True");
            // Logic for correct game state
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("¡Felicidades!");
            alert.setHeaderText("¡Has completado el Sudoku!");
            alert.setContentText("¡Felicidades! Has completado el Sudoku correctamente.");
            alert.showAndWait();
        } else {
            System.out.println("False");
            // Logic for incorrect game state
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("¡El Sudoku no está completo o contiene errores!");
            alert.setContentText("El Sudoku no está completo o contiene errores. Por favor, revisa y corrige tus números.");
            alert.showAndWait();
        }
    }

    @FXML
    public void reset() {
        System.out.println("Reset");
        sudoku.resetGame(); // Call the model reset method, the sudoku returns to its initial state.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField txt = new TextField();
                txt.setPrefHeight(56);
                txt.setPrefWidth(56);
                txt.setAlignment(Pos.CENTER);
                // Define the borders for columns 2 and 5 with a different thickness on the right-hand side
                if (j == 2 || j == 5) {
                    txt.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                            BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, new BorderWidths(1.0, 3.0, i == 2|| i==5? 3.0 : 1.0, 1.0), Insets.EMPTY)));
                }
                // Define the borders for rows 2 and 5 with a different thickness on the lower side
                else if (i == 2 || i == 5) {
                    txt.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
                            BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID, BorderStrokeStyle.SOLID,
                            CornerRadii.EMPTY, new BorderWidths(1.0 , j == 2|| j==5? 3.0 : 1.0, 3.0, 1.0), Insets.EMPTY)));
                }
                // standard form of rows and columns
                else {
                    txt.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
                }
                txt.setText(String.valueOf(sudoku.getTableSudoku()[i][j]));
                if (sudoku.getTableSudoku()[i][j] > 0) {
                    txt.setEditable(false);
                    txt.setBackground(new Background(new BackgroundFill(Color.rgb(232, 186, 186), null, null)));
                } else {
                    txt.setText("");
                    txt.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                    onKeyPressed(txt, i, j); // Call the onKeyPressed method here
                }
                tableSudokuGridPane.add(txt, j, i);
            }
        }
    }


    /*
     * Handles keypress events on a TextField.
     * @param textField The TextField in which keypress events will be handled.
     * @param row The row associated with the TextField.
     * @param col The column associated with the TextField
     */
    private void onKeyPressed(TextField textField, int row, int col) {
        textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String character = event.getCharacter();
                if (character.length() == 1 && Character.isDigit(character.charAt(0))) {
                    int newValue = Character.getNumericValue(character.charAt(0));
                    sudoku.setNumberInTableSodoku(newValue, row, col);
                    textField.setText(character);
                }
            }
        });
    }
}




