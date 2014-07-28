package com.shana.android.themeCreater.theme;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.shana.android.themeCreater.DataBaseHelper;
import com.shana.android.themeCreater.ItemName;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;

public class ThemeChooser {
	public static ArrayList<Theme> themes = new ArrayList<Theme>();
	public static ArrayList<ItemName> items = new ArrayList<ItemName>();
	private Context context;
	private DataBaseHelper dbHelper;
	public static boolean setTheme = false;
	public static int dataSize = 0;

	public ArrayList<Theme> getAllThemes(Context context) {

		this.context = context;
		dbHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
		RuntimeExceptionDao<Theme, Integer> ThemeDao = dbHelper
				.getThemeDataRuntimeExceptionDao();
		List<Theme> data = ThemeDao.queryForAll();
		if (themes.size() == 0) {
			Theme defaultTheme = new Theme("Default", Theme.LIGHT_THEME);
			themes.add(defaultTheme);

			Theme darkTheme = new Theme("Dark", Theme.DARK_THEME);
			themes.add(darkTheme);
		}
		if (themes.size() - 2 < data.size()) {

			int j = 0;
			if (!data.equals(null)) {

				Log.d("theme", "" + data.toString());
				if (setTheme == true && data.size() > dataSize) {
					j = dataSize;
				}

				for (int i = j; i < data.size(); i++) {
					dataSize = data.size();
					setTheme = true;
					Theme theme = new Theme(data.get(i).getName(), data.get(i)
							.getActionbarColorStart(), data.get(i)
							.getActionbarColorEnd(), data.get(i)
							.getActionbarTitleColor(), data.get(i)
							.getActionbarSubTitleColor(), data.get(i)
							.getIconColorStart(),
							data.get(i).getIconColorEnd(), data.get(i)
									.getTextColor(), data.get(i)
									.getBackgroundColorStart(), data.get(i)
									.getBackgroundColorEnd(), data.get(i)
									.getTileBackgroundColorStart(), data.get(i)
									.getTileBackgroundColorEnd(), data.get(i)
									.getTileForegroundColorStart(), data.get(i)
									.getTileForegroundColorEnd(), data.get(i)
									.getStrokeColor(), data.get(i)
									.getBaseTheme());
					themes.add(theme);
				}

			}

			OpenHelperManager.releaseHelper();
		}
		return themes;
	}

	public void getItemNames() {

	}

	public static GradientDrawable getBackgroundColor(Theme theme) {
		GradientDrawable gd = new GradientDrawable(
				GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
						theme.getBackgroundColorStart(),
						theme.getBackgroundColorEnd() });
		gd.setStroke(0, theme.getStrokeColor());
		return gd;
	}

	public static GradientDrawable getActionBarColor(Theme theme) {
		GradientDrawable gd = new GradientDrawable(
				GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
						theme.getActionbarColorStart(),
						theme.getActionbarColorEnd() });
		gd.setStroke(0, theme.getStrokeColor());
		return gd;
	}

	public static GradientDrawable getTileBackgroundColor(Theme theme) {
		GradientDrawable gd = new GradientDrawable(
				GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
						theme.getTileBackgroundColorStart(),
						theme.getTileBackgroundColorEnd() });
		gd.setStroke(5, theme.getStrokeColor());
		gd.setCornerRadius(3.f);
		return gd;
	}

	public static GradientDrawable getTileForegoundColor(Theme theme) {
		GradientDrawable gd = new GradientDrawable(
				GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
						theme.getTileForegroundColorStart(),
						theme.getTileForegroundColorEnd() });

		return gd;
	}

}// End class ThemeChooser
