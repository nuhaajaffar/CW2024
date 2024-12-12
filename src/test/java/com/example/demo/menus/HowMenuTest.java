package com.example.demo.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HowMenuTest {

    private Stage mockStage;
    private HowMenu howMenu;

    @BeforeEach
    public void setUp() {
        mockStage = new Stage();
        howMenu = new HowMenu(mockStage, 750, 1300);
    }

    @Test
    public void testMenuInitialization() {
        // Ensure HowMenu is created without errors
        assertNotNull(howMenu);
    }
}
