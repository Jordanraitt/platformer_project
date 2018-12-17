package com.mygdx.platformtutorial.World;

import java.util.HashMap;

public enum TileType {

    GRASS(1, true, "Grass"),
    DIRT(2, false, "Dirt"),
    SKY(3, true, "Sky"),
    LAVA(4, true, "Lava"),
    CLOUD(5, false, "Cloud"),
    STONE(6, true, "Stone"),
    LOL(7, true, "Test"),
    LOL1(8, false, "Test"),
    LOL2(9, true, "Test"),
    LOL3(10, true, "Test"),
    LOL4(11, true, "Test"),
    LOL5(12, true, "Test");

    public static final int TILE_SIZE = 32;

    private int id;
    private boolean collidable;
    private String name;
    private float damage;

    private TileType (int id, boolean collidable, String name) {
        this(id, collidable, name, 0);
    }

    private TileType (int id, boolean collidable, String name, float damage) {
        this.id = id;
        this.collidable = collidable;
        this.name= name;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }

    private static HashMap<Integer, TileType> tileMap;

    static {
        tileMap = new HashMap<Integer, TileType> ();
        for(TileType tileType : TileType.values()) {
            tileMap.put(tileType.getId(), tileType);
        }
    }

    public static TileType getTileTypeById(int id) {
        return tileMap.get(id);
    }
}
