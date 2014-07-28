package com.shana.android.themeCreater;

import com.shana.android.themeCreater.R;
import com.shana.android.themeCreater.adapters.ThemeAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ThemeSelecter extends Activity implements OnItemClickListener {
	private ListView themeListView;
	private Button newThemeButton;
	DataBaseHelper dbHelper;

	
	/**
	 * selecting the theme from database or default theme
	 * go to the customizing function if want to customize the theme
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.theme_list);

		themeListView = (ListView) findViewById(R.id.listItem);
		newThemeButton = (Button) findViewById(R.id.newThemeButton);
		newThemeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(
						"com.shana.android.themeCreater.CUSTOMTHEME");
				startActivity(i);
			}
		});
		themeListView.setOnItemClickListener(this);

	}

	@Override
	protected void onResume() {
		super.onResume();
		ThemeAdapter themeAdapter = new ThemeAdapter(this);
		themeListView.setAdapter(themeAdapter);
	}
	/**
	 * sending the selected theme position to main class to display
	 */
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		MainActivity.themeNumber = position;
		finish();
	}
}
