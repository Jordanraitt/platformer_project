package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class Player extends Entity {

    private static final int SPEED = 100;
    private static final int JUMP_VELOCITY = 6;
    private boolean isDead = false;

    Texture image;


    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
        jump(deltaTime);

        super.update(deltaTime, gravity); //Apply gravity

        moveLeft(deltaTime);

        moveRight(deltaTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }

    public void jump(float deltaTime) {
        if ((Gdx.input.isKeyPressed(Keys.SPACE) && grounded) || ((Gdx.input.isKeyPressed(Keys.UP) && grounded) || ((Gdx.input.isKeyPressed(Keys.W))) && grounded)) {
            this.velocityY += JUMP_VELOCITY * getWeight();
        } else if (((Gdx.input.isKeyPressed(Keys.SPACE)) && !grounded &&this.velocityY >0 )|| ((Gdx.input.isKeyPressed(Keys.W))&&!grounded &&this.velocityY > 0) || ((Gdx.input.isKeyPressed(Keys.UP)) && !grounded &&this.velocityY > 0)) {
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
        }
    }

    public void moveLeft(float deltaTime) {
        if ((Gdx.input.isKeyPressed(Keys.LEFT) && grounded) || (Gdx.input.isKeyPressed(Keys.A) && grounded))
            moveX((-SPEED - 20) * deltaTime);

        if ((Gdx.input.isKeyPressed(Keys.LEFT) && !grounded) || (Gdx.input.isKeyPressed(Keys.A) && !grounded))
            moveX((-SPEED + 10) * deltaTime);
    }

    public void moveRight(float deltaTime) {
        if ((Gdx.input.isKeyPressed(Keys.RIGHT) && grounded) || (Gdx.input.isKeyPressed(Keys.D) && grounded))
            moveX((SPEED + 20) * deltaTime);

        if ((Gdx.input.isKeyPressed(Keys.RIGHT) && !grounded) || (Gdx.input.isKeyPressed(Keys.D) && !grounded))
            moveX((SPEED - 10) * deltaTime);
    }
}
