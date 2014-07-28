package com.shana.android.themeCreater.icomoon;

public enum IcoMoon {
	Home('\ue600'), Quill('\ue607'), Menu2('\ue6b8'), Stack('\ue62d');

	private final Character character;

	private IcoMoon(Character character) {
		this.character = character;
	}

	public Character getChar() {
		return character;
	}

	@Override
	public String toString() {
		return character.toString();
	}
}
