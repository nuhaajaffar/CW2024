package com.example.demo;

import javafx.scene.shape.Rectangle;

public class UserProjectile extends Projectile {

	private static final String IMAGE_NAME = "userfire.png";
	private static final int IMAGE_HEIGHT = 125;
	private static final int HORIZONTAL_VELOCITY = 15;
	private final Rectangle hitbox;


	public UserProjectile(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
		hitbox = new Rectangle(initialXPos, initialYPos, 25, 30);
	}

	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
		updateHitbox();
	}
	
	@Override
	public void updateActor() {
		updatePosition();
	}

	@Override
	public Rectangle getHitbox() {
		return hitbox;
	}

	private void updateHitbox() {
		hitbox.setX(getLayoutX() + getTranslateX());
		hitbox.setY(getLayoutY() + getTranslateY());
	}
}
