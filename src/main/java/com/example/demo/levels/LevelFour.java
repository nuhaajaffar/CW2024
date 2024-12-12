package com.example.demo.levels;

import com.example.demo.actors.BossPlane;
import com.example.demo.ui.ShieldImage;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LevelFour extends LevelParent {
    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background2.jpg";
    private static final int PLAYER_INITIAL_HEALTH = 5;
    private final BossPlane boss;
    private LevelViewBoss levelViewBoss;
    private ShieldImage shieldImage;
    private Text bosshealthText;
    private Text shieldText;
    private Text levelFourText;

    public LevelFour(Stage stage, double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
        boss = new BossPlane();
        shieldImage = new ShieldImage(boss.getLayoutX(), boss.getLayoutY());
    }

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
        bosshealthText = new Text("BOSS HEALTH: " + boss.getHealth());
        bosshealthText.setFill(Color.DARKRED);
        bosshealthText.setStyle("-fx-font-size: 27;");
        bosshealthText.setX(getScreenWidth() - 225);
        bosshealthText.setY(40);
        getRoot().getChildren().add(bosshealthText);

        shieldText = new Text();
        shieldText.setFill(Color.BLACK);
        shieldText.setStyle("-fx-font-size: 27;");
        shieldText.setX(getScreenWidth() - 270);
        shieldText.setY(75);
        getRoot().getChildren().add(shieldText);

        levelFourText = new Text("LEVEL 4");
        levelFourText.setFill(Color.BLACK);
        levelFourText.setStyle("-fx-font-size: 35;");
        levelFourText.setX((getScreenWidth() /2) - 65);
        levelFourText.setY(50);
        getRoot().getChildren().add(levelFourText);
    }

    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            loseGame();
        }
        else if (boss.isDestroyed()) {
            winGame();
        }
    }

    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies() == 0) {
            addEnemyUnit(boss);
        }
    }

    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
    }

    @Override
    protected LevelViewBoss instantiateLevelViewBoss() {
        levelViewBoss = new LevelViewBoss(getRoot(), PLAYER_INITIAL_HEALTH);
        return levelViewBoss;
    }

    private void updateShieldPosition() {
        if (!boss.shieldExhausted()) {
            double offsetX = -65;
            double offsetY = 50;
            shieldImage.setTranslateX(boss.getTranslateX() + offsetX);
            shieldImage.setTranslateY(boss.getTranslateY() + offsetY);
        }
    }

    @Override
    protected void updateScene() {
        super.updateScene();
        bosshealthText.setText("BOSS HEALTH: " + boss.getHealth());
        if (boss.isShielded()) {
            shieldText.setText("SHIELD: Activated");
            shieldText.setFill(Color.GREEN);
            updateShieldPosition();
        }
        else {
            shieldText.setText("SHIELD: Deactivated");
            shieldText.setFill(Color.RED);
            updateShieldPosition();
        }

        if (boss.getFramesWithShieldActivated()==0) {
            getRoot().getChildren().remove(shieldImage);
            shieldImage.hideShield();
            boss.deactivateShield();
        }
        if (!boss.isShielded() && boss.shieldShouldBeActivated() && boss.getFramesWithShieldActivated()==0) {
            boss.activateShield();
            getRoot().getChildren().add(shieldImage);
            shieldImage.showShield();
        }
    }
}
