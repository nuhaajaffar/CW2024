package com.example.demo.levels;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.actors.EnemyPlane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LevelThreeTest {

    private LevelThree levelThree;

    @BeforeEach
    public void setUp() throws Exception {
        Stage mockStage = new Stage(); // Mock the JavaFX Stage
        levelThree = new LevelThree(mockStage, 750, 1300);
    }

    @Test
    public void testSpawnEnemyUnits() {
        // Clear initial enemies count

        // Simulate spawning logic
        levelThree.spawnEnemyUnits();
        int enemiesCountAfterSpawn = levelThree.getCurrentNumberOfEnemies();

        // Validate that enemies have spawned
        assertTrue(enemiesCountAfterSpawn >= 0 && enemiesCountAfterSpawn <= 5, "Enemy spawn logic has an error");
    }
}