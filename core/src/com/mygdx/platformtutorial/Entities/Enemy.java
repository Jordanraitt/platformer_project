package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class Enemy extends Entity {


    public Enemy(float x, float y, EntityType type, GameMap map) {
        super(x, y, type, map);
    }

    @Override
    public void render(SpriteBatch batch) {

    }
}
