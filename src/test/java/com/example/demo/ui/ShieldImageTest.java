package com.example.demo.ui;

import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShieldImageTest {

    private ShieldImage shieldImage;

    @BeforeEach
    public void setUp() {
        // Initialize a ShieldImage instance for testing
        shieldImage = new ShieldImage(100, 150);
    }

    @Test
    public void testShieldImageInitialization() {
        // Check initial x and y coordinates
        assertEquals(100, shieldImage.getLayoutX(), "Layout X should be set to 100");
        assertEquals(150, shieldImage.getLayoutY(), "Layout Y should be set to 150");

        // Ensure image is properly set
        assertNotNull(shieldImage.getImage(), "Shield image should not be null");

        // Ensure initial visibility is false
        assertFalse(shieldImage.isVisible(), "Shield should initially be invisible");

        // Check size
        assertEquals(200, shieldImage.getFitHeight(), "Shield height should be 200");
        assertEquals(200, shieldImage.getFitWidth(), "Shield width should be 200");
    }

    @Test
    public void testShowShield() {
        // Call method and test visibility
        shieldImage.showShield();
        assertTrue(shieldImage.isVisible(), "Shield should be visible after calling showShield");
    }

    @Test
    public void testHideShield() {
        // First show the shield
        shieldImage.showShield();
        assertTrue(shieldImage.isVisible(), "Shield should be visible after calling showShield");

        // Now hide it
        shieldImage.hideShield();
        assertFalse(shieldImage.isVisible(), "Shield should be invisible after calling hideShield");
    }
}
