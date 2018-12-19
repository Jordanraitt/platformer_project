package com.mygdx.platformtutorial.Entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.platformtutorial.World.GameMap;

import java.awt.*;

public abstract class Entity {

    protected Vector2 position;
    protected EntityType type;
    protected float velocityY = 0;
    protected GameMap map;
    protected boolean grounded = false;

    public Entity(float x, float y, EntityType type, GameMap map) {
        this.position = new Vector2(x, y);
        this.type = type;
        this.map = map;
    }

    public void update(float deltaTime, float gravity) {
        float newY = position.y;

        this.velocityY += gravity * deltaTime * getWeight();
        newY += this.velocityY * deltaTime;

        if (map.doesRectCollideWithMap(position.x, newY, getWidth(), getHeight())) {
            if (velocityY < 0) {
                this.position.y = (float) Math.floor(position.y);
                grounded = true;
            }
            this.velocityY = 0;
        } else {
            this.position.y = newY;
            grounded = false;
        }

//        if(map.doesRectCollideWithSpikes(position.x, position.y, getWidth(), getHeight())){
//            position.x = 65;
//            position.y = 65;
//        }


    }

    public abstract void render(SpriteBatch batch);

    protected void moveX(float amount) {
        float newX = position.x + amount;
        if (!map.doesRectCollideWithMap(newX, position.y, getWidth(), getHeight()))
            this.position.x = newX;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public EntityType getType() {
        return type;
    }

    public boolean isGrounded() {
        return grounded;
    }

    public int getWidth() {
        return type.getWidth();
    }

    public int getHeight() {
        return type.getHeight();
    }

    public float getWeight() {
        return type.getWeight();
    }


    public boolean overlaps (Rectangle r) {
        return this.getX() < r.x + r.width && this.getX() + this.getWidth() > r.x && this.getY() < r.y + r.height && this.getY() + this.getHeight() > r.y;
    }

}