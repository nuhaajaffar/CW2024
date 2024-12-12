package com.example.demo.menus;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class HowMenu extends MenuParent {
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/howmenu.png";
    private static final String BACK_BUTTON1 = "/com/example/demo/images/button/back1.png";
    private static final String BACK_BUTTON2 = "/com/example/demo/images/button/back2.png";

    public HowMenu(Stage stage, double screenHeight, double screenWidth) {
        super(stage, BACKGROUND_IMAGE_NAME, screenHeight, screenWidth);

        // Set appropriate button size
        double backButtonWidth = 125;
        double backButtonHeight = 125;

        // Set position properly at the top left corner
        double posX = 20; // Small margin from the left edge
        double posY = 20; // Small margin from the top edge
        buttonImage(BACK_BUTTON1, BACK_BUTTON2, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                goToMenu("Menu");
            }
        }, posX, posY, backButtonWidth, backButtonHeight);
    }
}
