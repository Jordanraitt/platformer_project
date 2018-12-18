package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.platformtutorial.World.GameMap;

public class Player extends Entity {

//    private static final int FRAME_COLS = 18, FRAME_ROWS = 35;

    private static final int SPEED = 100;
    private static final int JUMP_VELOCITY = 6;
    private boolean isDead = false;

    private Animation<TextureRegion> idleAnimation;
    private Texture idleImage;
    private float elapsedTime;



    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        idleImage = new Texture("idleam2.png");

        TextureRegion[][] tmpFrames = TextureRegion.split(idleImage, 18, 35);

        TextureRegion[] idleFrames = new TextureRegion[6];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
               idleFrames[index++] = tmpFrames[j][i];
            }
        }

        idleAnimation = new Animation<TextureRegion>(1f/6f, idleFrames);
//        elapsedTime = 0f;


    }

    @Override
    public void update(float deltaTime, float gravity) {
        jump(deltaTime);

        super.update(deltaTime, gravity); //Apply gravity

        moveLeft(deltaTime);

        moveRight(deltaTime);

//        if (map.doesPlayerCollideWithEnemy(position.x, position.y, getWidth(), getHeight())){
//            position.x = 65;
//            position.y = 65;
//        }

    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = idleAnimation.getKeyFrame(elapsedTime,true);
        batch.draw(currentFrame, position.x, position.y);

//        System.out.println("position.x = " + position.x);
//        System.out.println("position.y = " + position.y);
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

