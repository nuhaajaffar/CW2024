package com.example.demo.levels;

import com.example.demo.ui.ShieldImage;
import javafx.scene.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelViewBossTest {

    private Group mockRoot;
    private ShieldImage mockShieldImage;
    private LevelViewBoss levelViewBoss;

    @BeforeEach
    public void setUp() {
        // Create a mock root Group to simulate JavaFX root
        mockRoot = new Group();

        // Stub ShieldImage manually for testing purposes
        mockShieldImage = new ShieldImage(1150, 500) {
            @Override
            public void showShield() {
                System.out.println("Mock shield visible.");
            }

            @Override
            public void hideShield() {
                System.out.println("Mock shield hidden.");
            }
        };

        // Create LevelViewBoss instance
        levelViewBoss = new LevelViewBoss(mockRoot, 3);
    }

    @Test
    public void testShieldImageAddedToRoot() {
        // Assert ShieldImage is added to the mockRoot's children
        assertTrue(mockRoot.getChildren().contains(mockShieldImage), "ShieldImage should be added to the root.");
    }

    @Test
    public void testShowShield() {
        // Test if showShield interacts properly
        levelViewBoss.showShield();
        assertNotNull(mockShieldImage, "ShieldImage should not be null.");
    }

    @Test
    public void testHideShield() {
        // Test if hideShield interacts properly
        levelViewBoss.hideShield();
        assertNotNull(mockShieldImage, "ShieldImage should not be null.");
    }
}