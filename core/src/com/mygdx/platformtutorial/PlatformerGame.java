package com.mygdx.platformtutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.World.GameMap;
import com.mygdx.platformtutorial.World.TileType;
import com.mygdx.platformtutorial.World.TiledGameMap;

public class PlatformerGame extends ApplicationAdapter {

	OrthographicCamera camera;

	SpriteBatch batch;

	GameMap gameMap;

	float deltaX, deltaY;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();


		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		camera.update();

		gameMap = new TiledGameMap();
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float playerPosX = gameMap.getEntities().get(0).getX();
		float playerPosY = gameMap.getEntities().get(0).getY();
		float cameraHalfWidth = camera.viewportWidth/2;
		float cameraHalfHeight = camera.viewportHeight/2;
		float mapWidth = gameMap.getWidth() * TileType.TILE_SIZE;
		float mapHeight = gameMap.getWidth() * TileType.TILE_SIZE;

		camera.position.x = playerPosX;
		camera.position.y = playerPosY;

		if (playerPosX <= cameraHalfWidth) {
			camera.position.x = cameraHalfWidth;
//			camera.position.y = playerPosY;
		}
		if (playerPosX >= mapWidth - cameraHalfWidth){
			camera.position.x = mapWidth - cameraHalfWidth;
//			camera.position.y = playerPosY;
		}

		if (playerPosY <= cameraHalfHeight) {
			camera.position.y = cameraHalfHeight;
//			camera.position.x = playerPosX;

		}
		if (playerPosY >= (mapHeight - cameraHalfHeight)){
			camera.position.y = mapHeight - cameraHalfHeight;
//			camera.position.x = playerPosX;
		}

		camera.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(camera, batch);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
