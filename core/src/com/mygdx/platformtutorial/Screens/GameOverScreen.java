package com.mygdx.platformtutorial.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.platformtutorial.PlatformerGame;

public class GameOverScreen implements Screen {

    protected final PlatformerGame game;
    OrthographicCamera camera;

    public GameOverScreen(PlatformerGame game) {
        this.game = game;

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 720, 480);
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            camera.update();
            game.getBatch().setProjectionMatrix(camera.combined);

            game.getBatch().begin();
            game.getFont().draw(game.getBatch(), "GAME OVER ", camera.viewportWidth/2 - 50, camera.viewportHeight/2 + 75);
            game.getFont().draw(game.getBatch(), "Hit ENTER to continue, or BACKSPACE", (camera.viewportWidth/2) - 300, camera.viewportHeight/2);
            game.getFont().draw(game.getBatch(),"to go to the Main Menu!", camera.viewportWidth/2 - 200, camera.viewportHeight/2 - 25);
            game.getBatch().end();

            if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                game.setScreen(new GameScreen(game));
                dispose();
        }
            if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)) {
                game.setScreen(new MainMenuScreen(game));
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
