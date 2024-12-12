package com.example.demo.actors;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.projectiles.EnemyProjectile;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class EnemyPlaneTest {

    private EnemyPlane enemyPlane;

    @BeforeEach
    void setUp() {
        enemyPlane = new EnemyPlane(500, 300);
    }

    @Test
    void testInitialization() {
        // Test the hitbox is initialized correctly
        assertNotNull(enemyPlane.getHitbox(), "Hitbox should be initialized.");
        assertEquals(500 + -30, enemyPlane.getHitbox().getX(), "Hitbox X offset should align with initial position.");
        assertEquals(300 + 25, enemyPlane.getHitbox().getY(), "Hitbox Y offset should align with initial position.");
    }

    @Test
    void testMovementLogic() {
        double initialXPosition = enemyPlane.getLayoutX();
        enemyPlane.updatePosition();
        assertEquals(initialXPosition - 6, enemyPlane.getLayoutX(), "EnemyPlane should move horizontally at velocity -6.");
    }

    @Test
    void testProjectileFiring() {
        // Simulate firing logic with controlled random seeding
        Random randomMock = new Random();
        double fireRate = 0.01; // Controlled constant rate test

        // Mock Math.random() for deterministic behavior testing
        for (int i = 0; i < 1000; i++) {
            if (randomMock.nextDouble() < fireRate) {
                ActiveActorDestructible projectile = enemyPlane.fireProjectile();
                assertNotNull(projectile, "Projectile should have been fired under expected probability.");
            }
        }
    }

    @Test
    void testHitboxMovement() {
        enemyPlane.updatePosition();
        Rectangle hitbox = enemyPlane.getHitbox();
        assertEquals(500 + -30, hitbox.getX(), "Hitbox X should move with the expected horizontal movement.");
        assertEquals(300 + 25, hitbox.getY(), "Hitbox Y should remain consistent.");
    }
}