package com.example.demo.projectiles;

import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserProjectileTest {

    private UserProjectile userProjectile;

    @BeforeEach
    public void setUp() {
        // Create a UserProjectile instance at a starting position (100, 100).
        userProjectile = new UserProjectile(100, 100);
    }

    @Test
    public void testInitialState() {
        // Verify initial position
        assertEquals(100, userProjectile.getLayoutX(), "Initial X position should be 100");
        assertEquals(100, userProjectile.getLayoutY(), "Initial Y position should be 100");

        // Verify the hitbox is in the expected initial position
        Rectangle hitbox = userProjectile.getHitbox();
        assertEquals(100, hitbox.getX(), "Hitbox X position should match initial X");
        assertEquals(100, hitbox.getY(), "Hitbox Y position should match initial Y");
    }

    @Test
    public void testUpdatePosition() {
        // Call updatePosition to simulate horizontal movement
        userProjectile.updatePosition();

        // After one update, the projectile should have moved horizontally by HORIZONTAL_VELOCITY
        assertEquals(115, userProjectile.getLayoutX(), "Projectile should move horizontally by 15 units");
        Rectangle hitbox = userProjectile.getHitbox();
        assertEquals(115, hitbox.getX(), "Hitbox X should match new projectile X position");
    }

    @Test
    public void testGetHitbox() {
        // Ensure hitbox returns the expected Rectangle
        Rectangle hitbox = userProjectile.getHitbox();
        assertNotNull(hitbox, "Hitbox should not be null");
        assertEquals(25, hitbox.getWidth(), "Hitbox width should be 25");
        assertEquals(30, hitbox.getHeight(), "Hitbox height should be 30");
    }
}
