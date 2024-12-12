package com.example.demo.menus;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class GameOverMenu extends MenuParent {
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/losemenu.png";
    private static final String REPLAY_BUTTON1 = "/com/example/demo/images/button/replay1.png";
    private static final String REPLAY_BUTTON2 = "/com/example/demo/images/button/replay2.png";
    private static final String MENU_BUTTON1 = "/com/example/demo/images/button/menu1.png";
    private static final String MENU_BUTTON2 = "/com/example/demo/images/button/menu2.png";

    public GameOverMenu(Stage stage, double screenHeight, double screenWidth) {
        super(stage, BACKGROUND_IMAGE_NAME, screenHeight, screenWidth);
        initializeControls();
    }

    @Override
    protected void initializeControls() {
        background.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                KeyCode kc = e.getCode();
                if (kc == KeyCode.SPACE) {
                    goToNextLevel("LevelOne");
                }
            }
        });

        // Button dimensions
        double replayButtonWidth = 300;
        double replayButtonHeight = 100;

        double menuButtonWidth = 300;
        double menuButtonHeight = 100;

        // Set a bottom offset value
        double bottomOffset = 230;

        // Set positions dynamically
        double posX = (stage.getWidth() - replayButtonWidth) / 1.9;

        double replayPosY = stage.getHeight() - replayButtonHeight - bottomOffset; // Lower Replay button
        double menuPosY = replayPosY + replayButtonHeight + 20; // Space between the buttons

        // Replay button
        buttonImage(REPLAY_BUTTON1, REPLAY_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToNextLevel("LevelOne");
            }
        }, posX, replayPosY, replayButtonWidth, replayButtonHeight);

        // Menu button
        buttonImage(MENU_BUTTON1, MENU_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToMenu("Menu");
            }
        }, posX, menuPosY, menuButtonWidth, menuButtonHeight);
    }
}
