package com.example.demo.projectiles;

import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BossProjectileTest {

    @Test
    public void testConstructor() {
        // Arrange
        double initialYPos = 100.0;

        // Act
        BossProjectile projectile = new BossProjectile(initialYPos);

        // Assert
        assertNotNull(projectile, "Projectile should be initialized");
        assertEquals(950, projectile.getLayoutX(), "Initial X position should be 950");
        assertEquals(initialYPos, projectile.getLayoutY(), "Initial Y position should match");
    }

    @Test
    public void testUpdatePosition() {
        // Arrange
        double initialYPos = 100.0;
        BossProjectile projectile = new BossProjectile(initialYPos);

        // Act
        projectile.updatePosition();

        // Assert
        assertEquals(935, projectile.getLayoutX(), "Projectile should move horizontally by -15");
    }

    @Test
    public void testGetHitbox() {
        // Arrange
        double initialYPos = 100.0;
        BossProjectile projectile = new BossProjectile(initialYPos);

        // Act
        Rectangle hitbox = projectile.getHitbox();

        // Assert
        assertNotNull(hitbox, "Hitbox should not be null");
        assertEquals(950, hitbox.getX(), "Hitbox X should match projectile's initial position");
        assertEquals(initialYPos + 10, hitbox.getY(), "Hitbox Y should account for vertical offset");
    }
}
