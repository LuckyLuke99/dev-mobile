package com.devmobile.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.managers.ButtonsManager;
import com.devmobile.game.managers.TileManager;
import com.devmobile.game.scenes.MenuScreen;

public class DevMobile extends Game {
	public SpriteBatch batch;
	public TileManager tileManager;
	public ButtonsManager manager;
	public InputMultiplexer multiplexer;

	@Override
	public void create () {
		batch = new SpriteBatch();
		tileManager = new TileManager();
		GameInfo.tileManager = tileManager;
		GameInfo.menuSkin = tileManager.getMenu();

		multiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(multiplexer);

		manager = new ButtonsManager(this);
		setScreen(new MenuScreen(this));
		//setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
