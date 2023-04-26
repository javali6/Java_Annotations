package com.example.java_annotations;

import com.example.java_annotations.exampleClasses.ZipCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    VerticalInputText verticalInputText;

    @FXML
    private Button confirmButton;

    @FXML
    private HBox hBox;

    @FXML
    void confirm(ActionEvent event) {
        ZipCode zipCode = new ZipCode(verticalInputText.getTextInputControl().getText());
        System.out.println("Utworzono obiekt Zipcode: " + zipCode);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmButton.setDisable(true);
        verticalInputText = new VerticalInputText(hBox, confirmButton);

    }
}
