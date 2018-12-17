package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.platformtutorial.World.GameMap;

public class Player extends Entity {

    private static final int FRAME_COLS = 18, FRAME_ROWS = 35;
    private static final int SPEED = 100;
    private static final int JUMP_VELOCITY = 6;
    private Animation<TextureRegion> animation;
    private Texture image;
    private float elapsedTime;



    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        image = new Texture("idleam.png");

        TextureRegion[][] tmpFrames = TextureRegion.split(image, FRAME_COLS, FRAME_ROWS);

        TextureRegion[] image = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
               image[index++] = tmpFrames[j][i];
            }
        }

        animation = new Animation<TextureRegion>(1f/6f, image);

    }

    @Override
    public void update(float deltaTime, float gravity) {

        if ((Gdx.input.isKeyPressed(Keys.SPACE) && grounded && count == 0) || ((Gdx.input.isKeyPressed(Keys.UP) && grounded && count == 0) || ((Gdx.input.isKeyPressed(Keys.W))) && grounded && count == 0)) {
            this.velocityY += JUMP_VELOCITY * getWeight();
        } else if (((Gdx.input.isKeyPressed(Keys.SPACE)) && !grounded &&this.velocityY >0 )|| ((Gdx.input.isKeyPressed(Keys.W))&&!grounded &&this.velocityY > 0) || ((Gdx.input.isKeyPressed(Keys.UP)) && !grounded &&this.velocityY > 0)) {
            this.velocityY += JUMP_VELOCITY * getWeight() * deltaTime;
        }

        super.update(deltaTime, gravity); //Apply gravity

        if ((Gdx.input.isKeyPressed(Keys.LEFT) && grounded) || (Gdx.input.isKeyPressed(Keys.A) && grounded))
            moveX((-SPEED - 20) * deltaTime);

        if ((Gdx.input.isKeyPressed(Keys.RIGHT) && grounded) || (Gdx.input.isKeyPressed(Keys.D) && grounded))
            moveX((SPEED + 20) * deltaTime);

        if ((Gdx.input.isKeyPressed(Keys.LEFT) && !grounded) || (Gdx.input.isKeyPressed(Keys.A) && !grounded))
            moveX((-SPEED + 20) * deltaTime);

        if ((Gdx.input.isKeyPressed(Keys.RIGHT) && !grounded) || (Gdx.input.isKeyPressed(Keys.D) && !grounded))
            moveX((SPEED - 20) * deltaTime);

    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(elapsedTime,true);
//        batch.draw(animation.getKeyFrame(elapsedTime, true), position.x, position.y);
        batch.draw(currentFrame, position.x, position.y);
    }
}

