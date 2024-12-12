package com.example.demo.levels;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.actors.EnemyPlane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LevelTwo extends LevelParent {
	private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background1.jpg";
	private static final int TOTAL_ENEMIES = 5;
	private static final int KILLS_TO_ADVANCE = 20;
	private static final double ENEMY_SPAWN_PROBABILITY = .20;
	private static final int PLAYER_INITIAL_HEALTH = 5;
	private Text killProText;
	private Text killCountText;
	private Text levelTwoText;

	public LevelTwo(Stage stage, double screenHeight, double screenWidth) {
		super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
	}

	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();
			timeline.stop();
		}
		else if (userHasReachedKillTarget()) {
			timeline.stop();
			goToNextLevel("LevelThree");
		}
	}

	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
		killProText = new Text("KILL TO PROCEED: 20");
		killProText.setFill(Color.GREEN);
		killProText.setStyle("-fx-font-size: 27;");
		killProText.setX(getScreenWidth() - 285);
		killProText.setY(40);
		getRoot().getChildren().add(killProText);

		killCountText = new Text("KILLCOUNT: " + user.getNumberOfKills());
		killCountText.setFill(Color.BLACK);
		killCountText.setStyle("-fx-font-size: 27;");
		killCountText.setX(getScreenWidth() - 210);
		killCountText.setY(75);
		getRoot().getChildren().add(killCountText);

		levelTwoText = new Text("LEVEL 2");
		levelTwoText.setFill(Color.BLACK);
		levelTwoText.setStyle("-fx-font-size: 35;");
		levelTwoText.setX((getScreenWidth() /2) - 65 );
		levelTwoText.setY(50);
		getRoot().getChildren().add(levelTwoText);
	}

	@Override
	protected void spawnEnemyUnits() {
		int currentNumberOfEnemies = getCurrentNumberOfEnemies();
		for (int i = 0; i < TOTAL_ENEMIES - currentNumberOfEnemies; i++) {
			if (Math.random() < ENEMY_SPAWN_PROBABILITY) {
				double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
				ActiveActorDestructible newEnemy = new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
				addEnemyUnit(newEnemy);
			}
		}
	}

	@Override
	protected LevelView instantiateLevelView() {
		return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
	}

	@Override
	protected LevelViewBoss instantiateLevelViewBoss() {
		return null;
	}

	private boolean userHasReachedKillTarget() {
		return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
	}

	@Override
	protected void updateKillCount() {
		super.updateKillCount();
		killCountText.setText("KILLCOUNT: " + user.getNumberOfKills());
	}
}
