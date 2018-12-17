package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class Enemy extends Entity {

    private static final int SPEED = 50;

    Texture image;


    public Enemy(float x, float y, GameMap map) {
        super(x, y, EntityType.ENEMY, map);
        image = new Texture("enemy.png");
    }

    @Override
    public void update(float deltaTime, float gravity) {
    }

        @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }




}
