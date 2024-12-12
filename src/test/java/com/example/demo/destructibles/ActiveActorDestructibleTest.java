package com.example.demo.destructibles;

import com.example.demo.actors.ActiveActor;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActiveActorDestructibleTest {

    private TestActiveActorDestructible testActor;

    @BeforeEach
    public void setUp() {
        // Initialize the test actor with test values
        testActor = new TestActiveActorDestructible("testImage.png", 100, 10, 10);
    }

    @Test
    public void testDestroyFunctionality() {
        assertFalse(testActor.isDestroyed(), "Actor should not be destroyed initially.");

        testActor.destroy();

        assertTrue(testActor.isDestroyed(), "Actor should be destroyed after calling destroy.");
    }

    @Test
    public void testUpdateActor() {
        testActor.updateActor();
        // No functional effect expected here, but check that it's callable without exception
        assertDoesNotThrow(() -> testActor.updateActor());
    }

    @Test
    public void testGetHitbox() {
        Rectangle hitbox = testActor.getHitbox();
        assertNotNull(hitbox, "Hitbox should not be null.");
    }

    @Test
    public void testUpdatePosition() {
        testActor.updatePosition();
        assertDoesNotThrow(() -> testActor.updatePosition());
    }
}

// Concrete subclass for testing purposes
class TestActiveActorDestructible extends ActiveActorDestructible {

    public TestActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos) {
        super(imageName, imageHeight, initialXPos, initialYPos);
    }

    @Override
    public void updatePosition() {
        // Simulate simple movement for testing
    }

    @Override
    public void updateActor() {
        // Simulate actor updates for testing purposes
    }

    @Override
    public void takeDamage() {
        destroy();
    }

    @Override
    public Rectangle getHitbox() {
        return new Rectangle(10, 10); // Mock simple hitbox
    }
}