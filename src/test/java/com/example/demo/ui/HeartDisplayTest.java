package com.example.demo.ui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeartDisplayTest {

    private HeartDisplay heartDisplay;

    @BeforeEach
    public void setUp() {
        // Initialize the HeartDisplay with a sample position and a number of hearts to display
        heartDisplay = new HeartDisplay(100, 100, 5);
    }

    @Test
    public void testInitialization() {
        // Verify the number of hearts initialized in the HBox container
        HBox container = heartDisplay.getContainer();
        assertEquals(5, container.getChildren().size(), "Should initialize with 5 hearts.");
    }

    @Test
    public void testRemoveHeart() {
        // Remove one heart and test if the number of hearts decreases
        heartDisplay.removeHeart();
        HBox container = heartDisplay.getContainer();
        assertEquals(4, container.getChildren().size(), "Should have 4 hearts after one is removed.");
    }
}
