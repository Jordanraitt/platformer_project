package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class Enemy extends Entity {

    private static final int SPEED = 50;
    private boolean movingLeft = false;

    Texture image;


    public Enemy(float x, float y, GameMap map) {
        super(x, y, EntityType.ENEMY, map);
        image = new Texture("enemy.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
        if(!movingLeft)
            while (TileType)
            moveX(SPEED * deltaTime);

        if(movingLeft) {
            moveX(-SPEED * deltaTime);
        }
        super.update(deltaTime, gravity);

    }

        @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }




}
