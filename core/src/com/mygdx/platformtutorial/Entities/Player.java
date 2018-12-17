package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class Player extends Entity {

    private static final int SPEED = 80;
    private static final int JUMP_VELOCITY = 5;

    Texture image;



    public Player (float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("player.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
        if ((Gdx.input.isKeyPressed(Keys.SPACE) && grounded) || ((Gdx.input.isKeyPressed(Keys.UP) && grounded) || ((Gdx.input.isKeyPressed(Keys.W))) && grounded))
            this.velocityY += JUMP_VELOCITY * getWeight();
        else if (((Gdx.input.isKeyPressed(Keys.W))  && !grounded && this.velocityY > 0) || ((Gdx.input.isKeyPressed(Keys.W))  && !grounded && this.velocityY > 0) || ((Gdx.input.isKeyPressed(Keys.W))  && !grounded && this.velocityY > 0))
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;

        super.update(deltaTime, gravity); //Apply gravity

        if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
            moveX(-SPEED * deltaTime);


        if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed((Keys.D))) {
            moveX(SPEED * deltaTime);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }
}
