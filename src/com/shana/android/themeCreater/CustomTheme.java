package com.shana.android.themeCreater;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.shana.android.themeCreater.R;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.ValueBar;
import com.shana.android.themeCreater.adapters.ItemAdapter;
import com.shana.android.themeCreater.theme.Theme;
/***
 * this class is helping ton customizing the color and taking the 
 * values of color
 * 
 * @author shanaka
 *
 */
public class CustomTheme extends Activity implements OnItemClickListener,
		OnCheckedChangeListener, OnClickListener {
	private ListView list;
	private ColorPicker picker;
	private Context context;
	ItemAdapter itemAdapter;
	private RadioGroup selectRadio;
	private String themeName = "Default";
	private Button btnSave;
	private EditText customThemeName;
	DataBaseHelper dbHelper;
	private String customName = "Custom Theme";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_theme_creator);
		context = this;
		itemAdapter = new ItemAdapter(context);
		list = (ListView) findViewById(R.id.color_listView);
		selectRadio = (RadioGroup) findViewById(R.id.radioGroupTheme);
		customThemeName = (EditText) findViewById(R.id.etxtThemeName);
		picker = (ColorPicker) findViewById(R.id.picker);
		ValueBar valueBar = (ValueBar) findViewById(R.id.valuebar);
		OpacityBar opacityBar = (OpacityBar) findViewById(R.id.opacitybar);
		btnSave = (Button) findViewById(R.id.btnSave);

		list.setAdapter(new ItemAdapter(this));

		picker.addValueBar(valueBar);
		picker.addOpacityBar(opacityBar);
		list.setOnItemClickListener(this);
		selectRadio.setOnCheckedChangeListener(this);
		btnSave.setOnClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View arg1, int position,
			long arg3) {
		ItemName temp = (ItemName) itemAdapter.getItem(position);
		temp.setColor(picker.getColor());
		itemAdapter.notifyDataSetChanged();
		list.invalidateViews();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.radioDark:
			RadioButton btnDark = (RadioButton) findViewById(R.id.radioDark);
			themeName = btnDark.getText().toString();

		case R.id.radioDefault:
			RadioButton btnDefault = (RadioButton) findViewById(R.id.radioDefault);
			themeName = btnDefault.getText().toString();
		}
	}

	/**
	 * saving the color in theme object as user select
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int baseTheme = 0;
		Theme theme;
		try {
			customName = customThemeName.getText().toString();
			if (themeName.equals("Dark")) {
				theme = new Theme(customName, Theme.DARK_THEME);
				baseTheme = Theme.DARK_THEME;
			} else {
				theme = new Theme(customName, Theme.LIGHT_THEME);
				baseTheme = Theme.LIGHT_THEME;
			}

			dbHelper = OpenHelperManager.getHelper(this, DataBaseHelper.class);
			RuntimeExceptionDao<Theme, Integer> ThemeDao = dbHelper
					.getThemeDataRuntimeExceptionDao();
			ThemeDao.create(new Theme(customName, (ItemAdapter.items.get(0))
					.getColor(), (ItemAdapter.items.get(1)).getColor(),
					(ItemAdapter.items.get(2)).getColor(), (ItemAdapter.items
							.get(3)).getColor(), (ItemAdapter.items.get(4))
							.getColor(), (ItemAdapter.items.get(5)).getColor(),
					(ItemAdapter.items.get(6)).getColor(), (ItemAdapter.items
							.get(7)).getColor(), (ItemAdapter.items.get(8))
							.getColor(), (ItemAdapter.items.get(9)).getColor(),
					(ItemAdapter.items.get(10)).getColor(), (ItemAdapter.items
							.get(11)).getColor(), (ItemAdapter.items.get(12))
							.getColor(),
					(ItemAdapter.items.get(13)).getColor(), baseTheme));
			OpenHelperManager.releaseHelper();
		} catch (Exception e) {
		}
		finish();

	}
}
