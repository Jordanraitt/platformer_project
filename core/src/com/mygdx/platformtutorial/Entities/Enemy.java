package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;
import com.mygdx.platformtutorial.World.TileType;

public class Enemy extends Entity {

    private static final int SPEED = 50;
    private boolean movingLeft = false;
    private boolean isCollidable = true;

    Texture image;


    public Enemy(float x, float y, GameMap map) {
        super(x, y, EntityType.ENEMY, map);
        image = new Texture("enemy.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
        super.update(deltaTime, gravity);

        if(!movingLeft) {
            if (!map.isEnemyOnFloor(getX() + 2, getY() - 32, getHeight(), getWidth()) || map.doesRectCollideWithMap(getX(), getY(), getHeight(), getWidth())) {
                movingLeft = true;
            }
            moveX(SPEED * deltaTime);
        }


        if(movingLeft) {
            if(!map.isEnemyOnFloor(getX() - 2, getY() - 32, getHeight(), getWidth()) || map.doesRectCollideWithMap(getX() - 2, getY(), getHeight(), getWidth()))  {
                movingLeft = false;
            }
            moveX(-SPEED * deltaTime);
        }


    }

        @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }

}
