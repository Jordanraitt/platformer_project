package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;

public class EndButton extends Entity {

    Texture image;


    public EndButton(float x, float y, GameMap map) {
        super(x, y, EntityType.ENDBUTTON, map);
        image = new Texture("floor_button.png");
    }


    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, position.x, position.y, getWidth(), getHeight());
    }
}
