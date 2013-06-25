package com.example.game1exp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class SurfaceViewTest extends Activity{

	FastRenderView renderView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		renderView = new FastRenderView(this);

		setContentView(renderView);
	}

	protected void onResume() {
		super.onResume();
		renderView.resume();
	}

	protected void onPause() {
		super.onPause();
		renderView.pause();
	}

	class FastRenderView extends SurfaceView implements Runnable ,OnTouchListener{
		Thread renderThread = null;
		SurfaceHolder holder;

		volatile boolean running = false;

		public FastRenderView(Context context) {
			super(context);
			holder = getHolder();
		}

		public void resume() {
			running = true;
			renderThread = new Thread(this);
			renderThread.start();
		}

		public void run() {
			while (running) {
				if (!holder.getSurface().isValid())
					continue;
				Canvas canvas = holder.lockCanvas();
				canvas.drawRGB(255, 0, 0);
				holder.unlockCanvasAndPost(canvas);
			}
		}

		public void pause() {
			running = false;
			while (true) {
				try {
					renderThread.join();
					return;

				} catch (InterruptedException e) {

				}
			}
		}

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			Log.d("Logging the view ",v.toString());
			Log.d("Touch", "Touch");
			return true;
		}
	}


}
