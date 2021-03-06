package com.mygdx.platformtutorial.Entities;

public enum EntityType {

    PLAYER("player", 16, 32, 25),
    ENEMY("enemy", 24, 24, 25),
    ENDBUTTON("end button", 25, 10, 50);

    private String id;
    private int width, height;
    private float weight;

    EntityType(String id, int width, int height, float weight) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }
}
