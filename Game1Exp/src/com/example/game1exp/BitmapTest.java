package com.example.game1exp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BitmapTest extends Activity {
	int i = 0;
	char direction = 'd';
	int screenwidth, screenheight;

	class RenderView extends View {
		Bitmap bob565;
		Paint paint;
		Bitmap bob4444;
		Rect dst = new Rect();
		Random rand = new Random();

		public RenderView(Context context) {
			
			super(context);
			Display display = getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
			screenwidth = size.x;
			screenheight = size.y;
			paint = new Paint();

			try {
				AssetManager assetManager = context.getAssets();
				InputStream inputStream = assetManager.open("bobrgb888.png");
				bob565 = BitmapFactory.decodeStream(inputStream);
				inputStream.close();
				Log.d("BitmapText",
						"bobrgb888.png format : " + bob565.getConfig());

				inputStream = assetManager.open("bobargb8888.png");
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inPreferredConfig = Bitmap.Config.ARGB_4444;
				bob4444 = BitmapFactory
						.decodeStream(inputStream, null, options);
				inputStream.close();
				Log.d("BitmapText",
						"bobargb8888.png format" + bob4444.getConfig());

			} catch (IOException e) {

			} finally {
				// inputStream.close();
			}
		}

		protected void onDraw(Canvas canvas) {
			// canvas.drawRGB(0, 0, 0);
			dst.set(50, 50, 350, 350);
//			switch (direction) {
//			case 'd':
//				i++;
//				
//				// canvas.drawBitmap(bob4444, i++, i++, null);
//				canvas.drawCircle(i, 100, 30, paint);
//				break;
//			case 'u':
//				i--;
//				// canvas.drawBitmap(bob4444, i--, i--, null);
//				canvas.drawCircle(i, 100, 30, paint);
//				break;
//			}
//			// canvas.drawBitmap(bob565, null, dst, null);
//			if (i == 300) {
//				direction = 'u';
//				// reverse the motion
//			}
//			if (i == 50) {
//				direction = 'd';
//			}
			canvas.drawCircle(i++, 100, 30, paint);
			if(i==screenwidth){
				//reset i to 0 so that it will give an impression of coming from the right again;
				i=0;
			}
			// try {
			// Thread.sleep(1);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			invalidate();

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindow
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new RenderView(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bitmap_test, menu);
		return true;
	}

}
