package com.example.demo.actors;

import com.example.demo.destructibles.ActiveActorDestructible;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FighterPlaneTest {

    private FighterPlane fighterPlane;

    @Test
    void testInitialization() {
        assertEquals(1, fighterPlane.getHealth(), "Health should be initialized to 1.");
    }

    @Test
    void testTakeDamage() {
        fighterPlane.takeDamage();
        assertEquals(0, fighterPlane.getHealth(), "Health should decrement after taking damage.");
        fighterPlane.takeDamage();
        assertEquals(-1, fighterPlane.getHealth(), "Health should continue decrementing even below zero.");
    }

    @Test
    void testFireProjectileXPosition() {
        fighterPlane.setLayoutX(100);
        fighterPlane.setTranslateX(50);
        double projectileX = fighterPlane.getProjectileXPosition(10);
        assertEquals(160, projectileX, "Projectile X position should align with offset.");
    }

    @Test
    void testFireProjectileYPosition() {
        fighterPlane.setLayoutY(200);
        fighterPlane.setTranslateY(50);
        double projectileY = fighterPlane.getProjectileYPosition(10);
        assertEquals(260, projectileY, "Projectile Y position should align with offset.");
    }
}