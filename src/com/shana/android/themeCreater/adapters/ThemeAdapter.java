package com.shana.android.themeCreater.adapters;

import java.util.ArrayList;
import java.util.List;

import com.shana.android.themeCreater.R;
import com.shana.android.themeCreater.DataBaseHelper;
import com.shana.android.themeCreater.theme.Theme;
import com.shana.android.themeCreater.theme.ThemeChooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/***
 * this one automatically generate list view and view all of themes 
 * @author shanaka
 *
 */

public class ThemeAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private TextView themeTxtView;
	private ArrayList<Theme> themes;
	DataBaseHelper dbHelper;
	private int i = 0;
	List<Theme> themeData;

	public ThemeAdapter(Context context) {
		ThemeChooser themeChooser = new ThemeChooser();
		this.context = context;
		this.themes = themeChooser.getAllThemes(context);
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return themes.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		i++;
		View grid = convertView;

		if (grid == null) {
			grid = inflater
					.inflate(
							context.getResources().getLayout(
									R.layout.theme_item), null);
		} else {
			grid = convertView;
		}

		themeTxtView = (TextView) grid.findViewById(R.id.themeName);
		String themeName = themes.get(position).getName();
		themeTxtView.setText(themeName);
		return grid;
	}
}
