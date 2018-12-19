package com.mygdx.platformtutorial.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.Entities.Player;
import com.mygdx.platformtutorial.PlatformerGame;
import com.mygdx.platformtutorial.World.CoinSpawn;
import com.mygdx.platformtutorial.World.GameMap;
import com.mygdx.platformtutorial.World.TileType;
import com.mygdx.platformtutorial.World.TiledGameMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen implements Screen {

    final PlatformerGame game;

    OrthographicCamera camera;
    GameMap gameMap;
    Texture coinImage;
    int coinsGathered;
    CoinSpawn coinSpawn;

    public GameScreen(final PlatformerGame gam) {
        this.game = gam;

        coinImage = new Texture(Gdx.files.internal("coin.png"));

        float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();


		camera = new OrthographicCamera();
		camera.setToOrtho(false, 720, 480);
		camera.update();

		gameMap = new TiledGameMap();


        coinsGathered = 0;

        coinSpawn = new CoinSpawn();
        coinSpawn.spawnCoins();

    }



    @Override
    public void show() {

    }

    public void render(float delta) {
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
		}
		if (playerPosX >= mapWidth - cameraHalfWidth){
			camera.position.x = mapWidth - cameraHalfWidth;
		}

		if (playerPosY <= cameraHalfHeight) {
			camera.position.y = cameraHalfHeight;

		}
		if (playerPosY >= (mapHeight - cameraHalfHeight)){
			camera.position.y = mapHeight - cameraHalfHeight;
		}

		camera.update();
		gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(camera, game.getBatch());

        if (gameMap.doesRectCollideWithSpikes(playerPosX, playerPosY, gameMap.getEntities().get(0).getWidth(), gameMap.getEntities().get(0).getHeight()) || gameMap.doesPlayerCollideWithEnemy(playerPosX, playerPosY, gameMap.getEntities().get(0).getWidth(), gameMap.getEntities().get(0).getHeight())){
            game.setScreen(new GameOverScreen(this.game));
        }

        game.getBatch().begin();
        for (Rectangle coin : coinSpawn.getCoins()){
            game.getBatch().draw(coinImage, coin.x, coin.y, coin.width,coin.height);
        }
        game.getBatch().end();

        Iterator<Rectangle> iter = coinSpawn.getCoins().iterator();
        while (iter.hasNext()) {
            Rectangle coin = iter.next();
            coin.y += 0 * Gdx.graphics.getDeltaTime();
            if(coin.y < 0)
                iter.remove();
            if (gameMap.getEntities().get(0).overlaps(coin)){
                coinsGathered += 1;
                iter.remove();
            }
        }

        float positionX = camera.position.x - cameraHalfWidth + 350;
        float positionY = camera.position.y - cameraHalfHeight + 400;

        if (playerPosX <= cameraHalfWidth) {
            positionX = 350;
        }
        if (playerPosX >= mapWidth - cameraHalfWidth){
            positionX = mapWidth - 365;
        }

        if (playerPosY <= cameraHalfHeight) {
            positionY = 400;

        }
        if (playerPosY >= (mapHeight - cameraHalfHeight)){
            positionY = mapHeight - (mapHeight - 410);
        }

        game.getBatch().begin();
        game.getFont2().draw(game.getBatch(), "Score: " + coinsGathered, positionX, positionY);
        game.getBatch().end();

        if (gameMap.doesPlayerCollideWithEndButton(playerPosX, playerPosY, gameMap.getEntities().get(0).getWidth(), gameMap.getEntities().get(0).getWidth())) {
            game.setScreen(new WinScreen(this.game));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }
	@Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
