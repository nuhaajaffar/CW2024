package com.example.demo.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import com.example.demo.levels.LevelParent;
import com.example.demo.menus.MenuParent;

/**
 * The Controller class handles game navigation, transitions between game states,
 * and menu interactions. It implements Observer to monitor changes or events
 * triggered by menus or game levels.
 */
public class Controller implements Observer {

	private static final String MENU_CLASS_NAME = "com.example.demo.menus.Menu";
	private final Stage stage;
	private LevelParent currentLevel;

	/**
	 * Constructs a new Controller object, initializing the application window stage.
	 *
	 * @param stage The main application window's stage used for UI rendering.
	 */
	public Controller(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Launches the game by displaying the initial menu scene.
	 * Sets up the game state and menu navigation.
	 *
	 * @throws Exception Various exceptions that can arise during reflection.
	 */
	public void launchGame() throws Exception {
		stage.show();
		goToMenu(MENU_CLASS_NAME);
	}

	/**
	 * Dynamically loads and transitions to a specific game level using reflection.
	 *
	 * @param className Full class name of the level to load.
	 * @throws Exception Any exception encountered during dynamic class loading.
	 */
	private void goToLevel(String className) throws Exception {
		Class<?> levelClass = Class.forName(className);
		Constructor<?> constructor = levelClass.getConstructor(Stage.class, double.class, double.class);

		LevelParent levelInstance = (LevelParent) constructor.newInstance(stage, stage.getHeight(), stage.getWidth());
		levelInstance.addObserver(this);

		Scene scene = levelInstance.initializeScene();
		stage.setScene(scene);
		levelInstance.startGame();
	}

	/**
	 * Dynamically loads and transitions to a specific menu system.
	 * Handles logic based on menu type (e.g., PauseMenu, MainMenu).
	 *
	 * @param menuClassName Full class name of the menu to load.
	 * @throws Exception Various exceptions encountered during reflection.
	 */
	private void goToMenu(String menuClassName) throws Exception {
		System.out.println("Loading menu: " + menuClassName);

		Class<?> menuClass = Class.forName(menuClassName);
		Constructor<?> constructor;

		MenuParent menuInstance;
		if ("com.example.demo.menus.PauseMenu".equals(menuClassName)) {
			constructor = menuClass.getConstructor(Stage.class, double.class, double.class, LevelParent.class);
			menuInstance = (MenuParent) constructor.newInstance(stage, stage.getWidth(), stage.getHeight(), currentLevel);
		} else {
			constructor = menuClass.getConstructor(Stage.class, double.class, double.class);
			menuInstance = (MenuParent) constructor.newInstance(stage, stage.getWidth(), stage.getHeight());
		}

		menuInstance.addObserver(this);
		Scene scene = menuInstance.initializeScene();
		stage.setScene(scene);
	}

	/**
	 * Handles updates triggered by observed subjects (e.g., menu buttons or game events).
	 * Dynamically determines if the update corresponds to a menu or game level change.
	 *
	 * @param observable The source of the event (menu/level).
	 * @param arg The argument passed during the notification (name of menu/level).
	 */
	@Override
	public void update(Observable observable, Object arg) {
		String name = (String) arg;
		System.out.println("Received transition request to: " + name);

		try {
			if (name.contains("Menu")) {
				goToMenu("com.example.demo.menus." + name);
			} else {
				goToLevel("com.example.demo.levels." + name);
			}
		} catch (Exception e) {
			showErrorAlert(e);
		}
	}

	/**
	 * Displays an error alert if an exception occurs during a transition.
	 *
	 * @param e The exception to show in the alert.
	 */
	private void showErrorAlert(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText("An error occurred: " + e.getClass().getSimpleName());
		alert.show();
	}
}
