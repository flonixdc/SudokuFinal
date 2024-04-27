package org.example.sudokufinal.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
//Represents the stage for the Sudoku game view.
public class SudokuGameStage extends Stage {
    //Initializes the Sudoku game stage.
    public SudokuGameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/sudokufinal/sudoku-view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setTitle("Sudoku");
        // Set the icon for the stage
        getIcons().add(new Image(String.valueOf(getClass().getResource("/org/example/sudokufinal/images/IcSudoku.png"))));
        setScene(scene);
        setResizable(false);
        show();
    }
}