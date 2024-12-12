package com.example.demo.actors;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.projectiles.BossProjectile;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class BossPlaneTest {

    private BossPlane bossPlane;

    @BeforeEach
    void setUp() {
        bossPlane = new BossPlane();
    }

    @Test
    void testInitialization() {
        // Verify default values after initialization
        assertNotNull(bossPlane.getHitbox(), "Hitbox should be initialized.");
        assertFalse(bossPlane.isShielded(), "Shield should not be active initially.");
        assertEquals(0, bossPlane.getFramesWithShieldActivated(), "Shield frame count should be zero.");
    }

    @Test
    void testMovementBoundaries() {
        // Simulate out-of-bound movement logic.
        bossPlane.moveVertically(-500); // Attempt to move out of upper range.
        bossPlane.updatePosition();
        assertTrue(bossPlane.getLayoutY() + bossPlane.getTranslateY() >= -50, "Position should respect upper bounds.");

        bossPlane.moveVertically(600); // Attempt to move out of lower range.
        bossPlane.updatePosition();
        assertTrue(bossPlane.getLayoutY() + bossPlane.getTranslateY() <= 475, "Position should respect lower bounds.");
    }

    @Test
    void testShieldActivation() {
        // Force shield activation logic.
        bossPlane.activateShield();
        bossPlane.updateActor();
        assertTrue(bossPlane.isShielded(), "Shield should be active after activation.");

        bossPlane.deactivateShield();
        bossPlane.updateActor();
        assertFalse(bossPlane.isShielded(), "Shield should deactivate properly.");
    }

    @Test
    void testProjectileFiring() {
        // Force a projectile firing scenario to test logic.
        bossPlane = new BossPlane();
        bossPlane.fireProjectile();
        ActiveActorDestructible projectile = bossPlane.fireProjectile();
        assertTrue(projectile instanceof BossProjectile, "Projectile should fire.");
    }

    @Test
    void testHitboxUpdate() {
        bossPlane.moveVertically(10);
        bossPlane.updatePosition();
        Rectangle hitbox = bossPlane.getHitbox();
        assertEquals(bossPlane.getLayoutX() + bossPlane.getTranslateX(), hitbox.getX(), "Hitbox X should match movement.");
        assertEquals(bossPlane.getLayoutY() + bossPlane.getTranslateY() + 80, hitbox.getY(), "Hitbox Y should adjust with movement.");
    }

    @Test
    void testShieldExhaustion() {
        // Simulate shield reaching its maximum active frames.
        for (int i = 0; i < 500; i++) {
            bossPlane.updateActor();
        }
        assertTrue(bossPlane.shieldExhausted(), "Shield should deactivate after max active frames.");
    }
}