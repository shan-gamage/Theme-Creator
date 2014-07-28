package com.shana.android.themeCreater.icomoon;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.widget.TextView;

public class IcoMoonTextView extends TextView {
	
	private final static String NAME = "ICOMOON";
	private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(
			12);

	public IcoMoonTextView(Context context) {
		super(context);
		if (!isInEditMode())
			init();

	}

	public IcoMoonTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		if (!isInEditMode())
			init();
	}

	public void init() {
		Typeface typeface = sTypefaceCache.get(NAME);
		if (typeface == null) {
			typeface = Typeface.createFromAsset(getContext().getAssets(),
					"icomoon.ttf");			
			sTypefaceCache.put(NAME, typeface);
		}

		setTypeface(typeface);

	}

}
