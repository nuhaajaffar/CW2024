package com.example.demo.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
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

        this.currentLevel = currentLevel;
    }

    @Override
    public void resumeGame() {
        if (currentLevel != null) {
            System.out.println("Resuming game...");
            currentLevel.startGame();
        } else {
            System.err.println("Cannot resume, currentLevel is null!");
        }
    }
}