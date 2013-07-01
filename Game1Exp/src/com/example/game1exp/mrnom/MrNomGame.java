package com.example.game1exp.mrnom;

import com.example.game1exp.framework.Screen;
import com.example.game1exp.framework.impl.AndroidGame;

public class MrNomGame extends AndroidGame{
	public Screen getStartScreen(){
		return new LoadingScreen(this);
	}

}
