package com.example.java_annotations;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.concurrent.atomic.AtomicBoolean;

public class VerticalInputText implements Runnable {

    private HBox hBox;
    private ImageView imageView;
    private TextInputControl textInputControl;
    private Label label;
    private Button confirmButton;

    private Validator validator;

    private boolean isWorking = true;

    public VerticalInputText(HBox hBox, Button confirmButton) {
        this.hBox = hBox;
        this.confirmButton = confirmButton;
        imageView = new ImageView();
        textInputControl = new TextField();
        label = new Label();

        validator = new PatternValidator();

        hBox.getChildren().addAll(textInputControl, label, imageView);
        label.setText("<- my validated field");

        Thread thread = new Thread(this::run);
        thread.start();
    }


    @Override
    public void run() {
        while (isWorking) {
            registerValidator(validator);
        }
    }

    public void registerValidator(Validator validator) {

        imageView.setImage(new Image("bad.png"));
//        label.setText(validator.getMessage());

        validator.validate(textInputControl.getText());

        if (validator.isValid()) {
            Platform.runLater(()->{
                confirmButton.setDisable(false);
                imageView.setVisible(false);
                hBox.getChildren().add(new ImageView(new Image("good.png")));
            });
//            imageView.setImage(new Image("good.png"));
            isWorking = false;
        }

    }


    public ImageView getImageView() {
        return imageView;
    }

    public TextInputControl getTextInputControl() {
        return textInputControl;
    }

    public Label getLabel() {
        return label;
    }
}
