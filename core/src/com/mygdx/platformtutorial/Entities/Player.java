package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.platformtutorial.World.GameMap;

public class Player extends Entity {

//    private Animation idleAnimation;
//    private Animation jumpingAnimation;
//    private Animation runningAnimation;

    public enum State { FALLING, JUMPING, STANDING, RUNNING};
    private Animation<TextureRegion> idleAnimation;
    private boolean runningRight;
    private Texture idleImage;
    private static final int SPEED = 100;
    private static final int JUMP_VELOCITY = 6;
    private boolean isDead = false;
    private float elapsedTime;
    public State currentState;
    public State previousState;






    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        idleImage = new Texture("idleam2.png");
        runningRight = true;
        elapsedTime = 0;
        currentState = State.STANDING;
        previousState = State.STANDING;

///////////////////////FRAME ANIMATIONS
//         SINGLE LINE FRAME ANIMATION

//        Array<TextureRegion> frames = new Array<TextureRegion>();
//        for (int i = 0; i < 6; i++)
//             frames.add(new TextureRegion(get Texture(), i * 18, 0, 35));
//        runningAnimation = new Animation(0.1f, frames);
//        frames.clear();
//
//        idleAnimation = new TextureRegion(getTexture(0,18,0,35);
//
//         DOUBLE LINE FRAME ANIMATION

        TextureRegion[][] tmpFrames = TextureRegion.split(idleImage, 18, 35);
        TextureRegion[] idleFrames = new TextureRegion[6];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                idleFrames[index++] = tmpFrames[j][i];
            }
        }
        idleAnimation = new Animation(1f/6f, idleFrames);
///////////////////////
    }

    public TextureRegion getFrame(float deltaTime) {
        TextureRegion region;
        switch(currentState){
            case RUNNING:
               region = idleAnimation.getKeyFrame(elapsedTime, true);
               break;
               case STANDING:
            default:
                region = idleAnimation.getKeyFrame(elapsedTime, true);
        }

        if (((Gdx.input.isKeyPressed(Keys.LEFT) && grounded) || (Gdx.input.isKeyPressed(Keys.A) && grounded) || !runningRight) && !region.isFlipX()){
            region.flip(true, false);
            runningRight = false;
        }
        else if (((Gdx.input.isKeyPressed(Keys.RIGHT) && grounded) || (Gdx.input.isKeyPressed(Keys.D) && grounded) || runningRight)&& region.isFlipX()) {
            region.flip( true, false);
            runningRight = true;
        }

        return region;
    }

    @Override
    public void update(float deltaTime, float gravity) {
        jump(deltaTime);

        super.update(deltaTime, gravity); //Apply gravity

        moveLeft(deltaTime);

        moveRight(deltaTime);
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
//        TextureRegion currentFrame = idleAnimation.getKeyFrame(elapsedTime,true);
        batch.draw(this.getFrame(elapsedTime), position.x, position.y);

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

