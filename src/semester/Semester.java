/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author rajbi
 */
public class Semester extends Application {

    protected BorderPane getPane() {
        BorderPane border = new BorderPane();

        //HBOX FOR BUTTONS
        HBox buttonBox = new HBox(20);
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        buttonBox.getChildren().addAll(saveButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(5, 5, 5, 5));

        //Hbox for radiobuttons
        HBox radioBox = new HBox(20);
        radioBox.setPadding(new Insets(5, 5, 5, 5));
        RadioButton r1 = new RadioButton("1");
        RadioButton r2 = new RadioButton("2");
        RadioButton r3 = new RadioButton("3");
        RadioButton r4 = new RadioButton("4");
        radioBox.getChildren().addAll(r1, r2, r3, r4);

        ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r4.setToggleGroup(group);

        //HBox for checkbuttons
        HBox checkBox = new HBox(20);
        checkBox.setPadding(new Insets(5, 5, 5, 5));
        CheckBox c1 = new CheckBox("C1");
        CheckBox c2 = new CheckBox("C2");
        CheckBox c3 = new CheckBox("C3");
        CheckBox c4 = new CheckBox("C4");
        CheckBox c5 = new CheckBox("C5");
        checkBox.setAlignment(Pos.CENTER);
        checkBox.getChildren().addAll(c1, c2, c3, c4, c5);

        /**
         * HBox with nothing HBox not = new HBox(20);
         *
         * //HBox with ID HBox idBox = new HBox(20); Label id = new
         * Label("ID");
         *
         */
        TextField idtf = new TextField();
        /*
         * idBox.getChildren().addAll(id, idtf);
         *
         * //HBox with Program HBox proBox = new HBox(); Label pro = new
         * Label("Program"); 
        **/
        TextField field = new TextField();
        /*
         * proBox.getChildren().addAll(pro, field);*
         */
        //Grid pane to add all
        //should use gp.add(node, column number and row number)
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(5, 5, 5, 5));
        /**
         * gp.getChildren().add(0, not); gp.getChildren().add(1, idBox);
         * gp.getChildren().add(2, proBox); gp.getChildren().add(3, radioBox);
         * gp.getChildren().add(4, checkBox); gp.getChildren().add(5, not);
         * gp.getChildren().add(6, buttonBox);*
         */
        gp.add(new Label("ID"), 0, 0);
        gp.add(idtf, 1, 0);
        gp.add(new Label("Program"), 0, 1);
        gp.add(field, 1, 1);
        gp.add(new Label("Semester"), 0, 2);
        gp.add(radioBox, 1, 2);
        gp.add(new Label("Courses"), 0, 3);
        gp.add(checkBox, 1, 3);

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Infor i = new Infor();
                i.setProgram(field.getText());
                i.setId(idtf.getText());
                
                if (r1.isSelected()) {
                    i.setRadio(r1.getText());
                } else if (r2.isSelected()) {
                    i.setRadio(r2.getText());
                } else if (r3.isSelected()) {
                    i.setRadio(r3.getText());
                } else if (r4.isSelected()) {
                    i.setRadio(r4.getText());
                }
                
                if (c1.isSelected()) {
                    i.setC1(c1.getText());
                } else if (c2.isSelected()) {
                    i.setC2(c2.getText());
                } else if (c3.isSelected()) {
                    i.setC3(c3.getText());
                } else if (c4.isSelected()) {
                    i.setC4(c4.getText());
                } else if (c5.isSelected()) {
                    i.setC5(c5.getText());
                }

                FileWriter fileWriter;
                try {
                    fileWriter = new FileWriter("information.txt");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.append(i.toString());
                    printWriter.close();
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Saved", ButtonType.OK);
                    a.showAndWait();
                } catch (IOException ex) {
                    Logger.getLogger(Semester.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        border.setCenter(gp);

        border.setBottom(buttonBox);

        return border;

    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 350, 200);

        primaryStage.setTitle("Semester ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
