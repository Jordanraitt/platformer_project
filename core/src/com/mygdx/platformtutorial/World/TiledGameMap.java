package com.mygdx.platformtutorial.World;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledGameMap extends GameMap {

    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;

    public TiledGameMap() {
        tiledMap = new TmxMapLoader().load("map1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    @Override
    public void render(OrthographicCamera camera, SpriteBatch batch) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        batch.setProjectionMatrix(camera.combined);
        camera.position.set(entities.get(0).getX(), entities.get(0).getY(), 0);
        camera.update();
        batch.begin();
        super.render(camera, batch);
//        entities.add(new Coin(100, 80, this));
        batch.end();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
    }

    @Override
    public TileType getTileTypeByCoordinate(int layer, int col, int row) {
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(layer)).getCell(col, row);
        if (cell != null) {
            TiledMapTile tile = cell.getTile();

            if (tile != null) {
                int id = tile.getId();
                return TileType.getTileTypeById(id);
            }
        }
        return null;
    }

    @Override
    public int getWidth() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }

    @Override
    public int getHeight(){
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }

    @Override
    public int getLayers() {
        return tiledMap.getLayers().getCount();
    }
}
