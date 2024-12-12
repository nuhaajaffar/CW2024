package com.example.demo.menus;

import java.util.Observable;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public abstract class MenuParent extends Observable {
    public final Stage stage;
    private final Group root;
    private final Timeline timeline;
    private final Scene scene;
    protected final ImageView background;
    protected final double screenWidth;
    protected final double screenHeight;
    private boolean isPaused = false;

    public MenuParent(Stage stage, String backgroundImageName, double screenHeight, double screenWidth) {
        this.stage = stage;
        this.timeline = new Timeline();
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;

        this.root = new Group();
        this.scene = new Scene(root, screenWidth, screenHeight);

        // Debugging statement
        System.out.println("Trying to load background image: " + backgroundImageName);
        System.out.println("Resource path: " + getClass().getResource(backgroundImageName));

        // Check if the resource exists
        if (getClass().getResource(backgroundImageName) == null) {
            throw new IllegalArgumentException("Background image not found: " + backgroundImageName);
        }

        this.background = new ImageView(new Image(getClass().getResource(backgroundImageName).toExternalForm()));

        initializeBackground();
        stage.setScene(scene);
        stage.show();
    }

    public Scene initializeScene() {
        return scene;
    }

    protected void initializeControls() {
    }

    private void initializeBackground() {
        background.setFocusTraversable(true);
        background.setPreserveRatio(true);

        root.getChildren().add(background);
    }

    protected Button buttonImage(String buttonImagePath, String hoverImagePath, EventHandler eventHandler, double posX, double posY, double buttonWidth, double buttonHeight) {

        Image image = new Image(getClass().getResource(buttonImagePath).toExternalForm());

        double adjustedButtonWidth = buttonWidth;
        double adjustedButtonHeight = buttonHeight;

        ImageView buttonImageView = new ImageView(image);
        buttonImageView.setFitWidth(adjustedButtonWidth);
        buttonImageView.setFitHeight(adjustedButtonHeight);
        buttonImageView.setPreserveRatio(true);

        Button button = new Button();
        button.setGraphic(buttonImageView);
        button.setStyle("-fx-background-color: transparent;");

        button.setLayoutX(posX);
        button.setLayoutY(posY);

        button.setOnAction(eventHandler);

        if (hoverImagePath != null) {
            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Image hoverImage = new Image(getClass().getResource(hoverImagePath).toExternalForm());
                    ImageView hoverImageView = new ImageView(hoverImage);
                    hoverImageView.setFitWidth(adjustedButtonWidth);
                    hoverImageView.setFitHeight(adjustedButtonHeight);
                    hoverImageView.setPreserveRatio(true);
                    button.setGraphic(hoverImageView);
                }
            });

            button.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    button.setGraphic(buttonImageView);
                }
            });
        }
        root.getChildren().add(button);

        return button;
    }

    public void resumeGame() {
        isPaused = false;
        timeline.play();
    }

    public void goToNextLevel(String levelName) {
        setChanged();
        notifyObservers(levelName);

        timeline.stop();
    }

    public void goToMenu(String menuName) {
        setChanged();
        notifyObservers(menuName);

        timeline.stop();
    }

    public Stage getStage() {
        return stage;
    }
}