package com.shana.android.themeCreater;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.shana.android.themeCreater.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.shana.android.themeCreater.theme.Theme;

/***
 * 
 * this class create the data base
 * @author shanaka
 *
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "themedata.db";
	private static final int DATABASE_VERSION = 1;

	private Dao<Theme, Integer> themeDao = null;
	private RuntimeExceptionDao<Theme, Integer> themeRuntimeDao = null;

	public DataBaseHelper(Context context) {

		super(context, DATABASE_NAME, null, DATABASE_VERSION,
				R.raw.ormlite_config);
	}

	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {
		// TODO Auto-generated method stub
		try {
			Log.d("Created", "Created the table...!");
			TableUtils.createTable(connectionSource, Theme.class);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		try {
			TableUtils.dropTable(connectionSource, Theme.class, true);
			onCreate(database, connectionSource);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	public Dao<Theme, Integer> getDao() throws SQLException,
			java.sql.SQLException {
		if (themeDao == null) {
			themeDao = getDao(Theme.class);
		}
		return themeDao;
	}

	public RuntimeExceptionDao<Theme, Integer> getThemeDataRuntimeExceptionDao() {
		if (themeRuntimeDao == null) {
			themeRuntimeDao = getRuntimeExceptionDao(Theme.class);
		}
		return themeRuntimeDao;
	}

}
