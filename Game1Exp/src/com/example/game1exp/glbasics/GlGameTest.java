package com.example.game1exp.glbasics;

import java.util.Random;

import javax.microedition.khronos.opengles.GL10;

import com.example.game1exp.framework.Game;
import com.example.game1exp.framework.Screen;
import com.example.game1exp.framework.impl.GLGame;
import com.example.game1exp.framework.impl.GLGraphics;

public class GlGameTest extends GLGame{
	public Screen getStartScreen(){
		return new TestScreen(this);
	}
	
	class TestScreen extends Screen{
		GLGraphics glGraphics;
		Random rand = new Random();
		
		public TestScreen(Game game){
			super(game);
			glGraphics = ((GLGame)game).getGLGraphics();
		}

		@Override
		public void update(float deltaTime) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void present(float deltaTime) {
			// TODO Auto-generated method stub
			
			GL10 gl = glGraphics.getGL();
			gl.glClearColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT);//this clears the framebuffer
			
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
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

	@Override
	public void onSurfaceChanged(GL10 arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
