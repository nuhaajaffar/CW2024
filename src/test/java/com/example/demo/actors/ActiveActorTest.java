package com.example.demo.actors;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActiveActorTest {

    private TestActor testActor;

    @BeforeEach
    void setUp() {
        testActor = new TestActor();
    }

    @Test
    void testInitialization() {
        assertNotNull(testActor.getImage(), "Image should not be null after initialization");
        assertEquals(0.0, testActor.getLayoutX(), "Initial X position should be 0.0");
        assertEquals(0.0, testActor.getLayoutY(), "Initial Y position should be 0.0");
        assertEquals(10, testActor.getFitHeight(), "Image height should match the expected value");
    }

    @Test
    void testMoveHorizontally() {
        double initialX = testActor.getTranslateX();
        testActor.moveHorizontally(5.0);
        assertEquals(initialX + 5.0, testActor.getTranslateX(), "Actor should have moved 5 units horizontally");
    }

    @Test
    void testMoveVertically() {
        double initialY = testActor.getTranslateY();
        testActor.moveVertically(5.0);
        assertEquals(initialY + 5.0, testActor.getTranslateY(), "Actor should have moved 5 units vertically");
    }

    static class TestActor extends ActiveActor {

        public TestActor() {
            super("test.png", 10, 0, 0);
        }

        @Override
        public void updatePosition() {
            // Mock implementation or simulate movement logic here.
        }
    }
}