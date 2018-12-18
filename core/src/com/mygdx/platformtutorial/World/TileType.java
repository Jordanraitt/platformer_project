package com.mygdx.platformtutorial.World;

import java.util.HashMap;

public enum TileType {

    STONE(1, true, "Stone", false),
    DARK(2, false, "Dark", false),
    WALLV(3, true, "Wall Vertical", false),
    BLCORNER(4, true, "Bottom Left Corner", false),
    COLUMN(5, false, "Column", false),
    FLOOR(6, true, "Floor", false),
    TLCORNER(7, true, "Top Left Corner", false),
    CANDLE(8, false, "Candle", false),
    WALLVI(9, true, "Inversed Vertical Wall", false),
    BRCORNER(10, true, "Bottom Right Corner", false),
    TRCORNER(11, true, "Top Right Corner", false),
    SPIKES(12, false, "Spikes", true);

    public static final int TILE_SIZE = 32;

    private int id;
    private boolean collidable;
    private String name;
    private boolean doesKill;

//    private TileType (int id, boolean collidable, String name) {
//        this(id, collidable, name, false);
//    }

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

    public boolean doesKill() {
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
