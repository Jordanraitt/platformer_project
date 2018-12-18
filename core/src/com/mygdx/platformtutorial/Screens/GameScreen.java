package com.mygdx.platformtutorial.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.PlatformerGame;
import com.mygdx.platformtutorial.World.GameMap;
import com.mygdx.platformtutorial.World.TileType;
import com.mygdx.platformtutorial.World.TiledGameMap;

public class GameScreen implements Screen {

    final PlatformerGame game;

    OrthographicCamera camera;
    GameMap gameMap;

    public GameScreen(final PlatformerGame gam) {
        this.game = gam;

        float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();


		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		camera.update();

		gameMap = new TiledGameMap();
    }

    @Override
    public void show() {

    }

    public void render(float delta) {
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
        gameMap.render(camera, game.getBatch());

        if (gameMap.doesRectCollideWithSpikes(playerPosX, playerPosY, gameMap.getEntities().get(0).getWidth(), gameMap.getEntities().get(0).getHeight()) || gameMap.doesPlayerCollideWithEnemy(playerPosX, playerPosY, gameMap.getEntities().get(0).getWidth(), gameMap.getEntities().get(0).getHeight())){
            game.setScreen(new GameOverScreen(this.game));
        }


    }

    public void resize(int width, int height) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void hide() {

    }

    public void dispose() {

    }
}
