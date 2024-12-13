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

public class Controller implements Observer {

	private static final String MENU_CLASS_NAME = "com.example.demo.menus.Menu";
	private final Stage stage;
	private LevelParent currentLevel;

	public Controller(Stage stage) {
		this.stage = stage;
	}

	public void launchGame() throws Exception {
		stage.show();
		goToMenu(MENU_CLASS_NAME);
	}

	private void goToLevel(String className) throws Exception {
		Class<?> levelClass = Class.forName(className);
		Constructor<?> constructor = levelClass.getConstructor(Stage.class, double.class, double.class);

		LevelParent levelInstance = (LevelParent) constructor.newInstance(stage, stage.getHeight(), stage.getWidth());
		levelInstance.addObserver(this);

		Scene scene = levelInstance.initializeScene();
		stage.setScene(scene);
		levelInstance.startGame();
	}

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

	private void showErrorAlert(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText("An error occurred: " + e.getClass().getSimpleName());
		alert.show();
	}
}
