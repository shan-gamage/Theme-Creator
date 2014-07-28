package com.shana.android.themeCreater;

import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.shana.android.themeCreater.R;
import com.shana.android.themeCreater.icomoon.IcoMoon;
import com.shana.android.themeCreater.icomoon.IcoMoonTextView;
import com.shana.android.themeCreater.theme.Theme;
import com.shana.android.themeCreater.theme.ThemeChooser;

public class MainActivity extends SherlockActivity implements OnClickListener {

	static int themeNumber = 0;
	public static Theme theme;
	Context context;
	ThemeChooser themeChooser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		themeChooser = new ThemeChooser();
		context = MainActivity.this;
		theme = themeChooser.getAllThemes(context).get(themeNumber);
		initActionBar();
		initTextAndBackgroud();
	}

	private RelativeLayout mainRelativeLayout;
	private TextView sampleTextView;
	private IcoMoonTextView itemIconTextAwesome;
	private Button btnTheme;

	@SuppressWarnings("deprecation")
	private void initTextAndBackgroud() {
		mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainActivityRelativeLayout);
		mainRelativeLayout.setBackgroundDrawable(ThemeChooser
				.getBackgroundColor(theme));

		sampleTextView = (TextView) findViewById(R.id.sampleTextView);
		btnTheme = (Button) findViewById(R.id.btnTheme);
		btnTheme.setOnClickListener(this);
		sampleTextView.setTextColor(theme.getTextColor());

		itemIconTextAwesome = (IcoMoonTextView) findViewById(R.id.itemIconTextAwesome);

		itemIconTextAwesome.setText(IcoMoon.Home.toString());

		itemIconTextAwesome.setTextSize(TypedValue.COMPLEX_UNIT_PX, 150);

		Shader shader = new LinearGradient(0, 0, 0,
				itemIconTextAwesome.getTextSize(), theme.getIconColorStart(),
				theme.getIconColorEnd(), Shader.TileMode.CLAMP);
		itemIconTextAwesome.getPaint().setShader(shader);
		itemIconTextAwesome.setShadowLayer(1.5f, -1, 1, theme.getStrokeColor());

	}

	private ActionBar actionBar;

	private void initActionBar() {
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setBackgroundDrawable(ThemeChooser.getActionBarColor(theme));

		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		int subtitleId = getResources().getIdentifier("action_bar_subtitle",
				"id", "android");

		if (titleId == 0 && subtitleId == 0) {
			titleId = com.actionbarsherlock.R.id.abs__action_bar_title;
			subtitleId = com.actionbarsherlock.R.id.abs__action_bar_subtitle;
		}

		TextView titlteTextView = (TextView) findViewById(titleId);
		TextView subTItleTextView = (TextView) findViewById(subtitleId);
		titlteTextView.setTextColor(theme.getActionbarTitleColor());
		subTItleTextView.setTextColor(theme.getActionbarSubTitleColor());

	}// End initActionBar()

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnTheme:
			Intent i = new Intent(
					"com.shana.android.themeCreater.THEMESELECTER");
			startActivity(i);
			break;
		}

	}
}
