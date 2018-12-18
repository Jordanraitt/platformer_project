package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class Coin extends Entity {
    private boolean canCollect = true;

    Texture image;

    public Coin(float x, float y, GameMap map) {
        super(x, y, EntityType.COIN, map);
        image = new Texture("coin.gif");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }
}
