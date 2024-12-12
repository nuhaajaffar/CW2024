package com.example.demo.actors;

import com.example.demo.destructibles.ActiveActorDestructible;
import com.example.demo.projectiles.UserProjectile;

import javafx.scene.shape.Rectangle;

public class UserPlane extends FighterPlane {

	private static final String IMAGE_NAME = "userplane.png";
	private static final double Y_UPPER_BOUND = 25;
	private static final double Y_LOWER_BOUND = 600.0;
	private static final double INITIAL_X_POSITION = 5.0;
	private static final double INITIAL_Y_POSITION = 300.0;
	private static final int IMAGE_HEIGHT = 150;
	private static final double VERTICAL_VELOCITY = 14.0;
	private static final double HORIZONTAL_VELOCITY = 14.0;
	private static final int PROJECTILE_X_POSITION = 110;
	private static final int PROJECTILE_Y_POSITION_OFFSET = 20;
	private int velocityMultiplier;
	private int horizontalVelocityMultiplier;
	private int numberOfKills;
	private final Rectangle hitbox;
	private static final double HITBOX_X_OFFSET = 10.0;
	private static final double HITBOX_Y_OFFSET = 55.0;
	private static final double ACCELERATION = 1.2;
	private static final double VERTICAL_ACCELERATION = 1.5;
	private double verticalVelocity = 0.0;
	private double horizontalVelocity = 0.0;

	public UserPlane(int initialHealth) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, initialHealth);
		velocityMultiplier = 0;
		horizontalVelocityMultiplier=0;
		hitbox = new Rectangle(INITIAL_X_POSITION, INITIAL_Y_POSITION, 150, 20);
	}
	
	@Override
	public void updatePosition() {
		if (isMovingVertically()) {
			verticalVelocity += VERTICAL_ACCELERATION * velocityMultiplier;
			verticalVelocity = Math.max(-VERTICAL_VELOCITY, Math.min(verticalVelocity, VERTICAL_VELOCITY));
		}
		else {
			verticalVelocity *= 0.9;
			if (Math.abs(verticalVelocity) < 0.1) verticalVelocity = 0;
		}

		double initialTranslateY = getTranslateY();
		this.moveVertically(verticalVelocity);
		double newPositionY = getLayoutY() + getTranslateY();

		if (newPositionY < Y_UPPER_BOUND || newPositionY > Y_LOWER_BOUND) {
			this.setTranslateY(initialTranslateY);
		}

		if (isMovingHorizontally()) {
			horizontalVelocity += ACCELERATION * horizontalVelocityMultiplier;
			horizontalVelocity = Math.max(-HORIZONTAL_VELOCITY, Math.min(horizontalVelocity, HORIZONTAL_VELOCITY));
		}
		else {
			horizontalVelocity *= 0.9;
			if (Math.abs(horizontalVelocity) < 0.1) horizontalVelocity = 0;
		}

		double newXPosition = getTranslateX() + horizontalVelocity;

		if (newXPosition >= 0 && newXPosition <= getMaxXPosition()) {
			moveHorizontally(horizontalVelocity);
		}

		updateHitbox();
	}
	
	@Override
	public void updateActor() {
		updatePosition();
	}
	
	@Override
	public ActiveActorDestructible fireProjectile() {
		double projectileX = this.getLayoutX() + this.getTranslateX() + PROJECTILE_X_POSITION;
		double projectileY = this.getLayoutY() + this.getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
		return new UserProjectile(projectileX, projectileY);
	}

	private boolean isMovingVertically() {
		return velocityMultiplier != 0;
	}

	private boolean isMovingHorizontally() {
		return horizontalVelocityMultiplier != 0;
	}

	public void moveUp() {
		velocityMultiplier = -1;
	}

	public void moveDown() {
		velocityMultiplier = 1;
	}

	public void moveLeft() {
		horizontalVelocityMultiplier = -1;
	}
	public void moveRight() {
		horizontalVelocityMultiplier = 1;
	}

	public void stop() {
		velocityMultiplier = 0;
		horizontalVelocityMultiplier = 0;
	}

	public int getNumberOfKills() {
		return numberOfKills;
	}

	public void incrementKillCount() {
		numberOfKills++;
	}

	private void updateHitbox() {
		hitbox.setX(getLayoutX() + getTranslateX()+HITBOX_X_OFFSET);
		hitbox.setY(getLayoutY() + getTranslateY()+ HITBOX_Y_OFFSET);
	}
	@Override
	public Rectangle getHitbox() {
		return hitbox;
	}

	private double getMaxXPosition() {
		return this.getScene().getWidth() - this.getBoundsInLocal().getWidth();
	}
}
