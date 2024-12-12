package com.example.demo.menus;

import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Menu extends MenuParent {
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/mainmenu.png";
    private static final String PLAY_BUTTON1 = "/com/example/demo/images/button/play1.png";
    private static final String PLAY_BUTTON2 = "/com/example/demo/images/button/play2.png";
    private static final String HOW_BUTTON1 = "/com/example/demo/images/button/how1.png";
    private static final String HOW_BUTTON2 = "/com/example/demo/images/button/how2.png";

    public Menu(Stage stage, double screenHeight, double screenWidth) {
        super(stage, BACKGROUND_IMAGE_NAME, screenHeight, screenWidth);

        double buttonWidth = 300;
        double buttonHeight = 100;
        double buttonSpacing = 50; // Space between buttons

        // Calculate Y-position for horizontal alignment
        double buttonPosY = (stage.getHeight() / 1.2) - (buttonHeight / 1.2);

        // Calculate X-positions for horizontal placement
        double playButtonPosX = (stage.getWidth() / 2) - buttonWidth - (buttonSpacing / 2);
        double howButtonPosX = (stage.getWidth() / 2) + (buttonSpacing / 2);

        // Add the Play button
        buttonImage(PLAY_BUTTON1, PLAY_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToNextLevel("LevelOne");
            }
        }, playButtonPosX, buttonPosY, buttonWidth, buttonHeight);

        // Add the How button
        buttonImage(HOW_BUTTON1, HOW_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToMenu("HowMenu");
            }
        }, howButtonPosX, buttonPosY, buttonWidth, buttonHeight);
    }
}
