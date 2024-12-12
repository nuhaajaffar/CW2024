package com.example.demo.levels;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.actors.EnemyPlane;
import javafx.scene.Group;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.stream.Collectors;

public class LevelTwoTest {

    private LevelTwo levelTwo;
    private Stage mockStage;
    private Group rootMock;

    @BeforeEach
    public void setUp() {
        // Mock a JavaFX Stage and initialize the level
        mockStage = new Stage();
        rootMock = new Group(); // Simulate the game root
        levelTwo = new LevelTwo(mockStage, 750, 1300);
    }

    @Test
    public void testInitialization() {
        assertNotNull(levelTwo, "LevelTwo should initialize without error");
    }

    @Test
    public void testCheckIfGameOver() {
        // Simulate user destruction
        levelTwo.getUser().destroy();
        levelTwo.checkIfGameOver();
    }

    @Test
    public void testFriendlyUnitsInitialization() {
        // Call initialization and verify text nodes added to the root mock
        levelTwo.initializeFriendlyUnits();
        List<String> textChildren = rootMock.getChildren().stream()
                .filter(node -> node instanceof javafx.scene.text.Text)
                .map(node -> ((javafx.scene.text.Text) node).getText())
                .collect(Collectors.toList());

        assertTrue(textChildren.contains("KILL TO PROCEED: 20"), "Kill Progress text should be added");
        assertTrue(textChildren.contains("KILLCOUNT: 0"), "Kill Count text should initialize at 0");
        assertTrue(textChildren.contains("LEVEL 2"), "Level Text should be visible");
    }

    @Test
    public void testEnemySpawnLogic() {
        // Call spawnEnemyUnits and verify enemy counts increase
        int initialEnemyCount = levelTwo.getCurrentNumberOfEnemies();
        levelTwo.spawnEnemyUnits();

        assertNotEquals(initialEnemyCount, levelTwo.getCurrentNumberOfEnemies(),
                "Enemy spawn should result in a change in enemy count");
    }
}
