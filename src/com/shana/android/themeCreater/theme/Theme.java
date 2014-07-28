package com.shana.android.themeCreater.theme;

import com.actionbarsherlock.R;
import com.j256.ormlite.field.DatabaseField;

public class Theme {
	@Override
	public String toString() {
		return "Theme [id=" + id + ", name=" + name + ", actionbarColorStart="
				+ actionbarColorStart + ", actionbarColorEnd="
				+ actionbarColorEnd + ", actionbarTitleColor="
				+ actionbarTitleColor + ", actionbarSubTitleColor="
				+ actionbarSubTitleColor + ", iconColorStart=" + iconColorStart
				+ ", iconColorEnd=" + iconColorEnd + ", textColor=" + textColor
				+ ", backgroundColorStart=" + backgroundColorStart
				+ ", backgroundColorEnd=" + backgroundColorEnd
				+ ", tileBackgroundColorStart=" + tileBackgroundColorStart
				+ ", tileBackgroundColorEnd=" + tileBackgroundColorEnd
				+ ", tileForegroundColorStart=" + tileForegroundColorStart
				+ ", tileForegroundColorEnd=" + tileForegroundColorEnd
				+ ", strokeColor=" + strokeColor + ", baseTheme=" + baseTheme
				+ "]";
	}

	@DatabaseField(generatedId = true)
	int id;
	@DatabaseField
	private String name;
	@DatabaseField
	private int actionbarColorStart = 0xFFf7f7f7;
	@DatabaseField
	private int actionbarColorEnd = 0xFFf7f7f7;
	@DatabaseField
	private int actionbarTitleColor = 0xFF0970fb;
	@DatabaseField
	private int actionbarSubTitleColor = 0xFF09709a;
	@DatabaseField
	private int iconColorStart = 0xFF0970fb;
	@DatabaseField
	private int iconColorEnd = 0xFF0970aa;
	@DatabaseField
	private int textColor = 0xFF000000;
	@DatabaseField
	private int backgroundColorStart = 0xFFf0eff4;
	@DatabaseField
	private int backgroundColorEnd = 0xFFf0eff4;
	@DatabaseField
	private int tileBackgroundColorStart = 0xFFd7d3d0;
	@DatabaseField
	private int tileBackgroundColorEnd = 0xFFd7d3d0;
	@DatabaseField
	private int tileForegroundColorStart = 0xAA000000;
	@DatabaseField
	private int tileForegroundColorEnd = 0xAA000000;
	@DatabaseField
	private int strokeColor = 0xFF000000;

	public final static int LIGHT_THEME = R.style.Theme_Sherlock_Light;
	public final static int DARK_THEME = R.style.Theme_Sherlock_Light_DarkActionBar;

	private int baseTheme = LIGHT_THEME;

	public Theme() {
	}

	public Theme(String name, int actionbarColorStart, int actionbarColorEnd,
			int actionbarTitleColor, int actionbarSubTitleColor,
			int iconColorStart, int iconColorEnd, int textColor,
			int backgroundColorStart, int backgroundColorEnd,
			int tileBackgroundColorStart, int tileBackgroundColorEnd,
			int tileForegroundColorStart, int tileForegroundColorEnd,
			int strokeColor, int baseTheme) {
		super();
		this.name = name;
		this.actionbarColorStart = actionbarColorStart;
		this.actionbarColorEnd = actionbarColorEnd;
		this.actionbarTitleColor = actionbarTitleColor;
		this.actionbarSubTitleColor = actionbarSubTitleColor;
		this.iconColorStart = iconColorStart;
		this.iconColorEnd = iconColorEnd;
		this.textColor = textColor;
		this.backgroundColorStart = backgroundColorStart;
		this.backgroundColorEnd = backgroundColorEnd;
		this.tileBackgroundColorStart = tileBackgroundColorStart;
		this.tileBackgroundColorEnd = tileBackgroundColorEnd;
		this.tileForegroundColorStart = tileForegroundColorStart;
		this.tileForegroundColorEnd = tileForegroundColorEnd;
		this.strokeColor = strokeColor;
		this.baseTheme = baseTheme;
	}

	public Theme(String name, int baseTheme) {
		this.name = name;
		this.baseTheme = baseTheme;
		if (baseTheme != LIGHT_THEME) {
			actionbarColorStart = 0xFF0e0e0e;
			actionbarColorEnd = 0xFF0e0e0e;
			actionbarTitleColor = 0xFFFFFFFF;
			actionbarSubTitleColor = 0xFFD9D9D9;
			iconColorStart = 0xFFD9D9D9;
			iconColorEnd = 0xFFADADAD;
			textColor = 0xFF000000;
			backgroundColorStart = 0xFF7d7e7d;
			backgroundColorEnd = 0xFF7d7e7d;
			tileBackgroundColorStart = 0xFF0e0e0e;
			tileBackgroundColorEnd = 0xFF0e0e0e;
			tileForegroundColorStart = 0xAA000000;
			tileForegroundColorEnd = 0xAA000000;
			strokeColor = 0xFFaaaaaa;

		}
	}// End constructor

	
	
	public int getBaseTheme() {
		return baseTheme;
	}

	public void setBaseTheme(int baseTheme) {
		this.baseTheme = baseTheme;
	}

	public int getActionbarTitleColor() {
		return actionbarTitleColor;
	}

	public void setActionbarTitleColor(int actionbarTitleColor) {
		this.actionbarTitleColor = actionbarTitleColor;
	}

	public int getActionbarSubTitleColor() {
		return actionbarSubTitleColor;
	}

	public void setActionbarSubTitleColor(int actionbarSubTitleColor) {
		this.actionbarSubTitleColor = actionbarSubTitleColor;
	}

	public int getActionbarColorStart() {
		return actionbarColorStart;
	}

	public void setActionbarColorStart(int actionbarColorStart) {
		this.actionbarColorStart = actionbarColorStart;
	}

	public int getActionbarColorEnd() {
		return actionbarColorEnd;
	}

	public void setActionbarColorEnd(int actionbarColorEnd) {
		this.actionbarColorEnd = actionbarColorEnd;
	}

	public int getIconColorStart() {
		return iconColorStart;
	}

	public void setIconColorStart(int iconColorStart) {
		this.iconColorStart = iconColorStart;
	}

	public int getIconColorEnd() {
		return iconColorEnd;
	}

	public void setIconColorEnd(int iconColorEnd) {
		this.iconColorEnd = iconColorEnd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public int getBackgroundColorStart() {
		return backgroundColorStart;
	}

	public void setBackgroundColorStart(int backgroundColorStart) {
		this.backgroundColorStart = backgroundColorStart;
	}

	public int getBackgroundColorEnd() {
		return backgroundColorEnd;
	}

	public void setBackgroundColorEnd(int backgroundColorEnd) {
		this.backgroundColorEnd = backgroundColorEnd;
	}

	public int getTileBackgroundColorStart() {
		return tileBackgroundColorStart;
	}

	public void setTileBackgroundColorStart(int tileBackgroundColorStart) {
		this.tileBackgroundColorStart = tileBackgroundColorStart;
	}

	public int getTileBackgroundColorEnd() {
		return tileBackgroundColorEnd;
	}

	public void setTileBackgroundColorEnd(int tileBackgroundColorEnd) {
		this.tileBackgroundColorEnd = tileBackgroundColorEnd;
	}

	public int getTileForegroundColorStart() {
		return tileForegroundColorStart;
	}

	public void setTileForegroundColorStart(int tileForegroundColorStart) {
		this.tileForegroundColorStart = tileForegroundColorStart;
	}

	public int getTileForegroundColorEnd() {
		return tileForegroundColorEnd;
	}

	public void setTileForegroundColorEnd(int tileForegroundColorEnd) {
		this.tileForegroundColorEnd = tileForegroundColorEnd;
	}

	public int getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(int strokeColor) {
		this.strokeColor = strokeColor;
	}

	
}// End class Theme
