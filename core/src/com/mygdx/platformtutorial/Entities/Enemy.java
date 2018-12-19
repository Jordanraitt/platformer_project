package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.platformtutorial.World.GameMap;
import com.mygdx.platformtutorial.World.TileType;

public class Enemy extends Entity {

    private Animation<TextureRegion> walkAnimation;
    private static final int SPEED = 50;
    private boolean movingLeft = false;
    private boolean canKill = true;
    private float elapsedTime;
    Texture walkImage;


    public Enemy(float x, float y, GameMap map) {
        super(x, y, EntityType.ENEMY, map);
        walkImage = new Texture("enemyWalk.png");
        elapsedTime = 0;


        TextureRegion[][] wFrames = TextureRegion.split(walkImage, 24, 24);
        TextureRegion[] walkFrames = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 1; j++) {
                walkFrames[index++] = wFrames[j][i];
            }
        }

        walkAnimation = new Animation(1f/4f, walkFrames);

    }

    @Override
    public void update(float deltaTime, float gravity) {
        super.update(deltaTime, gravity);
        TextureRegion region;
        if(!movingLeft) {
            region = walkAnimation.getKeyFrame(elapsedTime,true);
            if (!map.isEnemyOnFloor(getX() + 2, getY() - 32, getHeight(), getWidth()) || map.doesRectCollideWithMap(getX() + 2, getY(), getHeight(), getWidth())) {
               region.flip(true, false);
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
        elapsedTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(elapsedTime,true);
        batch.draw(currentFrame, position.x, position.y, getWidth(), getHeight());
    }

}
