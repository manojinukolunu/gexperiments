package com.example.game1exp.mrnom;

import java.util.List;

import com.example.game1exp.framework.Game;
import com.example.game1exp.framework.Graphics;
import com.example.game1exp.framework.Screen;
import com.example.game1exp.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {

	public MainMenuScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-geneList<E>d method stub
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i=0;i<len;i++){
			TouchEvent event = touchEvents.get(i);
			//We check for the click event and capture the 
			//boundaries of the event and activate the appropriate
			// response
			if(event.type == TouchEvent.TOUCH_UP){
				if(inBounds(event,0,g.getHeight()-64,64,64)){
					Settings.soundEnabled = !Settings.soundEnabled;
					if(Settings.soundEnabled)
						Assets.click.play(1);
				}
				if(inBounds(event,64,220,192,42)){
					game.setScreen(new GameScreen(game));
					if (Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
				if(inBounds(event,64,220+42,192,42)){
					game.setScreen(new HighscoreScreen(game));
					if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
				if(inBounds(event,64,220+84,192,42)){
					game.setScreen(new HelpScreen(game));
					if(Settings.soundEnabled)
						Assets.click.play(1);
					return;
				}
			}
		}
	}
	
	
	/**
	 * Function to check if the event is in bound
	 * code is self explanatory dont need to explain more
	 */
	
	private boolean inBounds(TouchEvent event,int x,int y,int width, int height){
		if (event.x > x && event.x < x+width -1 &7 event.y > y && event.y < y+height-1)
			return true;
		else 
			return false;
	}
	
	@Override
	public void present(float deltaTime) {
		// TODO Auto-generated method stub
		
		Graphics g = game.getGraphics();
		
		g.drawPixmp(Assets.background,0,0);
		g.drawPixmap(Assets.logo,32,20);
		g.drawPixmap(Assets.mainMenu, 64, 220);
		
		if(Settings.soundEnabled)
			g.drawPixmap(Assets.buttons, 0, 416,0,0,64,64);
		else 
			g.drawPixmap(Assets.buttons, 0, 416,64,0,64,64);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
