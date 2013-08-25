package com.example.game1exp.framework.impl;

import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

public class GLGraphics {
	GLSurfaceView glView; // basic surface view
	GL10 gl; // GL10 object provides access to open gl 1.0 features

	/**
	 * Constructor just sets the glView for this class
	 * 
	 * @param glView
	 */

	GLGraphics(GLSurfaceView glView) {
		this.glView = glView;
	}

	public GL10 getGL() {
		return gl;
	}

	void setGL(GL10 gl) {
		this.gl = gl;
	}
	
	public int getWidth(){
		return glView.getWidth();
	}
	
	public int getHeight(){
		return glView.getHeight();
	}

}
