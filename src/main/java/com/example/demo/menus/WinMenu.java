package com.example.demo.menus;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class WinMenu extends MenuParent {
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/winmenu.png";
    private static final String REPLAY_BUTTON1 = "/com/example/demo/images/button/replay1.png";
    private static final String REPLAY_BUTTON2 = "/com/example/demo/images/button/replay2.png";
    private static final String MENU_BUTTON1 = "/com/example/demo/images/button/menu1.png";
    private static final String MENU_BUTTON2 = "/com/example/demo/images/button/menu2.png";

    public WinMenu(Stage stage, double screenHeight, double screenWidth) {
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

        buttonImage(REPLAY_BUTTON1, REPLAY_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToNextLevel("LevelOne");
            }
        }, posX, replayPosY, replayButtonWidth, replayButtonHeight);

        buttonImage(MENU_BUTTON1, MENU_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToMenu("Menu");
            }
        }, posX, menuPosY, menuButtonWidth, menuButtonHeight);
    }
}