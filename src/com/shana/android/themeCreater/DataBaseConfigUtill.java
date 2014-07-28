package com.shana.android.themeCreater;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.shana.android.themeCreater.theme.Theme;
/***
 * this class generate the ormlite config file in raw folder 
 * if it is not exist
 * if u want edit your table fields and create new data base first you need
 * to remove your ormlite_congig file from our raw folder
 * and run this class as a java application
 * 
 * @author shanaka
 *
 */
public class DataBaseConfigUtill extends OrmLiteConfigUtil {

	private static final Class<?>[] classes = new Class[] { Theme.class };

	public static void main(String args[]) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt", classes);
	}

}
