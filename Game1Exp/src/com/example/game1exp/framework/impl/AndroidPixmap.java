package com.example.game1exp.framework.impl;

import android.graphics.Bitmap;

import com.example.game1exp.framework.Graphics.PixmapFormat;
import com.example.game1exp.framework.Pixmap;

public class AndroidPixmap implements Pixmap{
	
	Bitmap bitmap;
	PixmapFormat format;
	
	
	public AndroidPixmap(Bitmap bitmap,PixmapFormat format){
		this.bitmap = bitmap;
		this.format = format;
	}
	@Override
	public int getWidth() {
		return bitmap.getWidth();
	}

	@Override
	public int getHeight() {
		return bitmap.getHeight();
	}

	@Override
	public PixmapFormat getFormat() {
		// TODO Auto-generated method stub
		return format;
	}

	@Override
	public void dispose() {
		bitmap.recycle();
		
	}

}
