package com.shana.android.themeCreater;

public class ItemName {

	private String itemName;
	private int color;

	public ItemName(String itemName, int color) {
		this.itemName = itemName;
		this.color = color;

	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
