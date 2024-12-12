package com.example.demo.menus;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import com.example.demo.levels.LevelParent;

public class PauseMenu extends MenuParent{

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/pausemenu.png";
    private static final String RESUME_BUTTON1 = "/com/example/demo/images/button/resume1.png";
    private static final String RESUME_BUTTON2 = "/com/example/demo/images/button/resume2.png";
    private static final String MENU_BUTTON1 = "/com/example/demo/images/button/menu1.png";
    private static final String MENU_BUTTON2 = "/com/example/demo/images/button/menu2.png";
    private LevelParent currentLevel;

    public PauseMenu(Stage stage, double screenHeight, double screenWidth, LevelParent currentLevel) {
        super(stage, BACKGROUND_IMAGE_NAME, screenHeight, screenWidth);

        // Button dimensions
        double resumeButtonWidth = 300;
        double resumeButtonHeight = 100;

        double menuButtonWidth = 300;
        double menuButtonHeight = 100;

        // Set a bottom offset value
        double bottomOffset = 230;

        // Set positions dynamically
        double posX = (stage.getWidth() - resumeButtonWidth) / 1.9;

        double resumePosY = stage.getHeight() - resumeButtonHeight - bottomOffset; // Lower Replay button
        double menuPosY = resumePosY + resumeButtonHeight + 20; // Space between the buttons

        buttonImage(RESUME_BUTTON1, RESUME_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resumeGame();
            }
        }, posX, resumePosY, resumeButtonWidth, resumeButtonHeight);

        buttonImage(MENU_BUTTON1, MENU_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToMenu("Menu");
            }
        }, posX, menuPosY, menuButtonWidth, menuButtonHeight);

        //this.currentLevel = currentLevel;
        //initializeControls();
    }

    /*@Override
    protected void initializeControls() {
        background.setFocusTraversable(true);
        background.requestFocus();
        background.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("Space");
                    resumeGame();
                }
            }
        });

        // Button dimensions
        double resumeButtonWidth = 300;
        double resumeButtonHeight = 100;

        double menuButtonWidth = 300;
        double menuButtonHeight = 100;

        // Set a bottom offset value
        double bottomOffset = 230;

        // Set positions dynamically
        double posX = (stage.getWidth() - resumeButtonWidth) / 1.9;

        double resumePosY = stage.getHeight() - resumeButtonHeight - bottomOffset; // Lower Replay button
        double menuPosY = resumePosY + resumeButtonHeight + 20; // Space between the buttons

        buttonImage(RESUME_BUTTON1, RESUME_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resumeGame();
            }
        }, posX, resumePosY, resumeButtonWidth, resumeButtonHeight);

        buttonImage(MENU_BUTTON1, MENU_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToMenu("Menu");
            }
        }, posX, menuPosY, menuButtonWidth, menuButtonHeight);
    }*/

    @Override
    public void resumeGame() {
        if (currentLevel != null) {
            System.out.println("Resuming game...");
            currentLevel.startGame();
        } else {
            System.err.println("Cannot resume, currentLevel is null!");
        }
    }


    private void transitionToLevel() {
        if (currentLevel != null) {
            System.out.println("Transitioning to level...");
            Scene levelScene = currentLevel.initializeScene();
            stage.setScene(levelScene);
            currentLevel.startGame();
        } else {
            System.out.println("currentLevel is null!");
        }
    }

}