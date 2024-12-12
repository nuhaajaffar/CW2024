package com.example.demo.menus;

import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuParentTest {

    private Stage mockStage;
    private MenuParent menuParent;

    @BeforeEach
    public void setUp() {
        menuParent = new MenuParent(mockStage, "/resources/test-bg.png", 750, 1300) {
            @Override
            protected void initializeControls() {
                // Overridden to bypass unnecessary JavaFX control logic
            }
        };
    }

    @Test
    public void testMenuParentInitialization() {
        // Ensure scene is initialized by verifying it gets created
        assert menuParent.initializeScene() != null;
    }

    @Test
    public void testGoToNextLevelNotifiesObserver() {
        menuParent.addObserver((observable, arg) -> {
            assert arg.equals("level1");
        });

        menuParent.goToNextLevel("level1");
    }

    @Test
    public void testGoToMenuNotifiesObserver() {
        menuParent.addObserver((observable, arg) -> {
            assert arg.equals("mainMenu");
        });

        menuParent.goToMenu("mainMenu");
    }
}
