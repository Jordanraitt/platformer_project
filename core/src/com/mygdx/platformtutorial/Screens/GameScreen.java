package com.mygdx.platformtutorial.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.Entities.Player;
import com.mygdx.platformtutorial.PlatformerGame;
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
    ArrayList<Rectangle> coins;
    Rectangle playerRec;
    int coinsGathered;

    public GameScreen(final PlatformerGame gam) {
        this.game = gam;

        coinImage = new Texture(Gdx.files.internal("coin.png"));
        coins = new ArrayList<Rectangle>();

        float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

//		player = (Player)(gameMap.getEntities().get(0));


		camera = new OrthographicCamera();
		camera.setToOrtho(false, 720, 480);
		camera.update();

		gameMap = new TiledGameMap();
        spawnCoin(180, 80);
        spawnCoin(100, 80);
        spawnCoin(120, 80);

        coinsGathered = 0;
//        convertPlayer(player);
    }

    public void spawnCoin(int x, int y){
        Rectangle coin = new Rectangle();
        coin.x = x;
        coin.y = y;
        coin.width = 16;
        coin.height = 16;
        coins.add(coin);
    }

//    public void convertPlayer(Player player){
//        Rectangle playerRect = new Rectangle();
//        playerRect.x = (int)(player.getX());
//        playerRect.y = (int)(player.getY());
//        playerRect.width = player.getWidth();
//        playerRect.height = (player.getHeight();
//        playerRec = playerRect;
//    }


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

        game.getBatch().begin();
        for (Rectangle coin : coins){
            game.getBatch().draw(coinImage, coin.x, coin.y, coin.height, coin.width);
        }
        game.getBatch().end();

        Iterator<Rectangle> iter = coins.iterator();
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
        game.getFont().draw(game.getBatch(), "Score:" + coinsGathered, positionX, positionY);
        game.getBatch().end();

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
//        coinImage.dispose();
    }
}
