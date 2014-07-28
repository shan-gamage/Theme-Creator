package com.shana.android.themeCreater.adapters;

import java.util.ArrayList;

import com.shana.android.themeCreater.R;
import com.shana.android.themeCreater.ItemName;
import com.shana.android.themeCreater.MainActivity;
import com.shana.android.themeCreater.theme.Theme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/***
 * this add all themes to arry list and view them   
 * @author shanaka
 *
 */

public class ItemAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	public static ArrayList<ItemName> items;
	private Theme theme;
	private int colorCode[] = new int[14];
	private String itemName[] = new String[14];
	private ItemName item;

	public ItemAdapter(Context context) {
		this.context = context;

		theme = MainActivity.theme;
		setObject();
		setItem();
	}

	public void setObject() {
		colorCode[0] = theme.getActionbarColorStart();
		itemName[0] = "Action bar Color Start";
		colorCode[1] = theme.getActionbarColorEnd();
		itemName[1] = "Action bar Color End";
		colorCode[2] = theme.getActionbarTitleColor();
		itemName[2] = "Action bar Title Color";
		colorCode[3] = theme.getActionbarSubTitleColor();
		itemName[3] = "Actionbar Sub Title Color";
		colorCode[4] = theme.getIconColorStart();
		itemName[4] = "IconColor Start";
		colorCode[5] = theme.getIconColorEnd();
		itemName[5] = "IconColor End";
		colorCode[6] = theme.getTextColor();
		itemName[6] = "TextColor";
		colorCode[7] = theme.getBackgroundColorStart();
		itemName[7] = "Background Color Start";
		colorCode[8] = theme.getBackgroundColorEnd();
		itemName[8] = "Background Color End";
		colorCode[9] = theme.getTileBackgroundColorStart();
		itemName[9] = "Tile Background Color Start";
		colorCode[10] = theme.getTileBackgroundColorEnd();
		itemName[10] = "Tile Background Color End";
		colorCode[11] = theme.getTileForegroundColorStart();
		itemName[11] = "Tile Foreground Color Start";
		colorCode[12] = theme.getTileForegroundColorEnd();
		itemName[12] = "Tile Foreground Color End";
		colorCode[13] = theme.getStrokeColor();
		itemName[13] = "Stroke Color";
	}

	public void setItem() {
		items = new ArrayList<ItemName>();
		for (int i = 0; i < itemName.length; i++) {
			item = new ItemName(itemName[i], colorCode[i]);
			items.add(item);
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// View view = convertView;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(
				context.getResources().getLayout(R.layout.themes), null);
		TextView itemName = (TextView) v.findViewById(R.id.txtVThemeItemName);
		TextView color = (TextView) v.findViewById(R.id.item_color);
		ItemName temp = items.get(position);
		itemName.setText(temp.getItemName());
		color.setBackgroundColor(temp.getColor());
		return v;

	}
}
