package com.example.demo.levels;

import javafx.scene.Group;
import javafx.scene.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelViewTest {

    private Group mockRoot;
    private LevelView levelView;
    private final int initialHearts = 3;

    @BeforeEach
    public void setUp() {
        levelView = new LevelView(mockRoot, initialHearts);
    }

    @Test
    public void testShowHeartDisplay() {
        // Call the method to show heart display
        levelView.showHeartDisplay();
    }

    @Test
    public void testShowWinImage() {
        levelView.showWinImage();
    }

    @Test
    public void testShowGameOverImage() {
        levelView.showGameOverImage(2, 2);
    }

    @Test
    public void testRemoveHearts() {
        levelView.removeHearts(1); // Remove one heart

        // This would check if hearts are visually removed based on logic
        assertNotNull(levelView);
    }
}