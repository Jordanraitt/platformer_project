package com.mygdx.platformtutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.platformtutorial.Screens.GameScreen;

public class PlatformerGame extends Game {

//	OrthographicCamera camera;

	Game game;
	SpriteBatch batch;
	BitmapFont font;

	public PlatformerGame() {
		game = this;
	}

	//	GameMap gameMap;

//	float deltaX, deltaY;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();

		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		gameMap.dispose();
		font.dispose();
		super.dispose();
	}

	public SpriteBatch getBatch() {
		return this.batch;
	}

	public BitmapFont getFont() {
		return this.font;
	}
}
