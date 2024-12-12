package com.example.demo.destructibles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DestructibleTest {

    @Test
    public void testTakeDamageAndDestroy() {
        // Create mock implementation of the Destructible interface
        Destructible destructibleMock = new MockDestructible();

        // Call the methods and check their state changes
        destructibleMock.takeDamage();
        assertTrue(((MockDestructible) destructibleMock).isDamaged(), "Object should have taken damage");

        destructibleMock.destroy();
        assertTrue(((MockDestructible) destructibleMock).isDestroyed(), "Object should be destroyed");
    }

    // Mock class implementing Destructible
    private static class MockDestructible implements Destructible {
        private boolean damaged = false;
        private boolean destroyed = false;

        @Override
        public void takeDamage() {
            this.damaged = true; // Simulate the effect of taking damage
        }

        @Override
        public void destroy() {
            this.destroyed = true; // Simulate destruction
        }

        public boolean isDamaged() {
            return damaged;
        }

        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
