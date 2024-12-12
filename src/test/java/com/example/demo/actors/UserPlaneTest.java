package com.example.demo.actors;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.projectiles.UserProjectile;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPlaneTest {

    private UserPlane userPlane;
    private Scene mockScene;

    @Test
    void testMovementUpAndDown() {
        userPlane.moveUp();
        userPlane.updatePosition();
        assertTrue(userPlane.getTranslateY() < 300, "UserPlane should move upwards.");

        userPlane.moveDown();
        userPlane.updatePosition();
        assertTrue(userPlane.getTranslateY() > 300, "UserPlane should move downwards.");
    }

    @Test
    void testHorizontalMovementRight() {
        userPlane.moveRight();
        userPlane.updatePosition();
        assertTrue(userPlane.getTranslateX() > 0, "UserPlane should move horizontally to the right.");
    }

    @Test
    void testStopMovement() {
        userPlane.stop();
        userPlane.updatePosition();
        assertEquals(0, userPlane.getTranslateY(), "Vertical translation should reset to 0.");
        assertEquals(0, userPlane.getTranslateX(), "Horizontal translation should reset to 0.");
    }

    @Test
    void testProjectileFiring() {
        userPlane.setLayoutX(200);
        userPlane.setLayoutY(200);
        ActiveActorDestructible projectile = userPlane.fireProjectile();
        assertNotNull(projectile, "Projectile should be instantiated.");
        assertTrue(projectile instanceof UserProjectile, "Projectile should be an instance of UserProjectile.");
    }

    @Test
    void testHitboxUpdates() {
        userPlane.updatePosition();
        Rectangle hitbox = userPlane.getHitbox();
        assertNotNull(hitbox, "Hitbox should be updated after position changes.");
        assertEquals(10, hitbox.getX(), "Hitbox X offset should respect predefined offsets.");
        assertEquals(55, hitbox.getY(), "Hitbox Y offset should respect predefined offsets.");
    }

    @Test
    void testEdgeMovement() {
        userPlane.setTranslateX(-100); // Try to move outside the left boundary
        userPlane.updatePosition();
        assertTrue(userPlane.getTranslateX() >= 0, "UserPlane should respect the left movement edge.");

        userPlane.setTranslateX(900); // Try to move out to the right
        userPlane.updatePosition();
        assertTrue(userPlane.getTranslateX() <= 800, "UserPlane should respect the right movement edge.");
    }
}