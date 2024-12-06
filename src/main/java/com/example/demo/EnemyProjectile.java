package com.example.demo;

import javafx.scene.shape.Rectangle;

public class EnemyProjectile extends Projectile {
	
	private static final String IMAGE_NAME = "enemyFire.png";
	private static final int IMAGE_HEIGHT = 40;
	private static final int HORIZONTAL_VELOCITY = -10;
	private final Rectangle hitbox;


	public EnemyProjectile(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
		hitbox = new Rectangle(initialXPos, initialYPos, 20, IMAGE_HEIGHT/2);
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
		hitbox.setX(getLayoutY() + getTranslateY());
	}
}
