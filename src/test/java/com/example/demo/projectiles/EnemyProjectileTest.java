package com.example.demo.projectiles;

import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyProjectileTest {

    private EnemyProjectile enemyProjectile;

    @BeforeEach
    public void setUp() {
        // Initialize the test with a starting position
        enemyProjectile = new EnemyProjectile(100, 100);
    }

    @Test
    public void testUpdatePosition() {
        // Initial hitbox position and expected movement
        Rectangle initialHitbox = enemyProjectile.getHitbox();
        double initialX = initialHitbox.getX();
        double initialY = initialHitbox.getY();

        // Perform an update
        enemyProjectile.updatePosition();

        // Verify the projectile moves horizontally by -10
        assertEquals(initialX - 10, enemyProjectile.getHitbox().getX(), "Projectile should move left by 10");
        assertEquals(initialY, enemyProjectile.getHitbox().getY(), "Y-coordinate should remain unchanged");
    }

    @Test
    public void testHitboxUpdatesAfterMovement() {
        // Before movement
        Rectangle hitboxBefore = enemyProjectile.getHitbox();
        double initialX = hitboxBefore.getX();

        // Simulate movement
        enemyProjectile.updatePosition();
        Rectangle hitboxAfter = enemyProjectile.getHitbox();
        double updatedX = hitboxAfter.getX();

        // Validate movement expected horizontally by -10 units
        assertEquals(initialX - 10, updatedX, "Hitbox X should move left by 10 units after movement");
    }
}
