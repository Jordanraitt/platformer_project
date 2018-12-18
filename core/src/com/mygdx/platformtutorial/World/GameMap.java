package com.mygdx.platformtutorial.World;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.Entities.Enemy;
import com.mygdx.platformtutorial.Entities.Entity;
import com.mygdx.platformtutorial.Entities.Player;

import java.util.ArrayList;

public abstract class GameMap {

     protected ArrayList<Entity> entities;

     public GameMap() {
          entities = new ArrayList<Entity>();
          entities.add(new Player(65, 65, this));
          entities.add(new Enemy(400, 65, this));
          entities.add(new Enemy(90, 65, this));
     }

     public void render(OrthographicCamera camera, SpriteBatch batch) {
          for(Entity entity : entities) {
               entity.render(batch);
          }
     }

     public void update(float delta) {
          for (Entity entity : entities) {
               entity.update(delta, -9.8f);
          }
     }
     public abstract void dispose();

//     Gets a tile by pixel position within the game world at a specified later.
     public TileType getTileTypeByLocation(int layer, float x, float y){
         return this.getTileTypeByCoordinate(layer, (int) (x / TileType.TILE_SIZE), (int) (y / TileType.TILE_SIZE));
     }

//     Gets a tile at its coordinate within the map at a specified layer.
     public abstract TileType getTileTypeByCoordinate(int layer, int col, int row);


     public boolean doesRectCollideWithSpikes(float x, float y, int width, int height){
          for (int row = (int) (y/TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++){
               for(int col = (int) (x/TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++){
                    for (int layer = 0; layer < getLayers(); layer++) {
                         TileType type = getTileTypeByCoordinate(layer, col, row);
                         if (type != null && type.doesKill())
                              return true;
                    }
               }
          }
          return false;
     }

     public boolean isEnemyOnFloor(float x, float y, int width, int height){
          for (int row = (int) (y/TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++){
               for(int col = (int) (x/TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++){
                    for (int layer = 0; layer < getLayers(); layer++) {
                         TileType type = getTileTypeByCoordinate(layer, col, row);
                         if (type != null && type.getId() == 2)
                              return false;
                    }
               }
          }
          return true;
     }


     public boolean doesRectCollideWithMap(float x, float y, int width, int height) {
          if (x < 0 || y < 0 || x + width > getPixelWidth() || y + height > getPixelHeight())
               return true;

          for (int row = (int) (y / TileType.TILE_SIZE); row < Math.ceil((y + height) / TileType.TILE_SIZE); row++) {
               for (int col = (int) (x / TileType.TILE_SIZE); col < Math.ceil((x + width) / TileType.TILE_SIZE); col++) {
                    for (int layer = 0; layer < getLayers(); layer++) {
                         TileType type = getTileTypeByCoordinate(layer, col, row);
                         if (type != null && type.isCollidable())
                              return true;
                    }
               }
          }

          return false;
     }

     public abstract int getWidth();
     public abstract int getHeight();
     public abstract int getLayers();

     public ArrayList<Entity> getEntities(){
          return this.entities;
     }

     public int getPixelWidth() {
          return this.getWidth() * TileType.TILE_SIZE;
     }

     public int getPixelHeight() {
          return this.getHeight() * TileType.TILE_SIZE;
     }


}
