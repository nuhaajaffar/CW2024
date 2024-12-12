package com.example.demo.levels;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.Scene;
import javafx.stage.Stage;

import com.example.demo.actors.BossPlane;
import com.example.demo.ui.ShieldImage;

public class LevelFourTest {

    private Stage stage;
    private LevelFour levelFour;

    @BeforeEach
    public void setUp() throws Exception {
        // Simulate JavaFX Stage
        stage = new Stage();
        levelFour = new LevelFour(stage, 750, 1300);
    }

    @Test
    public void testInitialization() {
        assertNotNull(levelFour, "LevelFour instance should be created properly");
    }

    @Test
    public void testInitializeFriendlyUnits() {
        // This ensures that the UI elements are initialized
        levelFour.initializeFriendlyUnits();

        assertNotNull(levelFour.getRoot().getChildren(), "Root children should not be null");
        assertEquals(3, levelFour.getRoot().getChildren().size(), "Should have 3 elements initialized: boss health text, shield text, and level text");
    }
}
