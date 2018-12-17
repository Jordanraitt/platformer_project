package com.mygdx.platformtutorial.World;

import java.util.HashMap;

public enum TileType {

    STONE(1, true, "Stone"),
    DARK(2, false, "Dark"),
    WALLV(3, true, "Wall Vertical"),
    BLCORNER(4, true, "Bottom Left Corner"),
    COLUMN(5, false, "Column"),
    FLOOR(6, true, "Floor"),
    TLCORNER(7, true, "Top Left Corner"),
    CANDLE(8, false, "Candle"),
    WALLVI(9, true, "Inversed Vertical Wall"),
    BRCORNER(10, true, "Bottom Right Corner"),
    TRCORNER(11, true, "Top Right Corner"),
    SPIKES(12, true, "Spikes", true);

    public static final int TILE_SIZE = 32;

    private int id;
    private boolean collidable;
    private String name;
    private boolean doesKill;

    private TileType (int id, boolean collidable, String name) {
        this(id, collidable, name, true);
    }

    private TileType (int id, boolean collidable, String name, boolean doesKill) {
        this.id = id;
        this.collidable = collidable;
        this.name= name;
        this.doesKill = doesKill;
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

    public boolean getDamage() {
        return doesKill;
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
