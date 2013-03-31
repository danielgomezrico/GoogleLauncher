package com.makingiants.googlelauncher;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.rRhoDEGBMf.gpIpiBntrE126271.Airpush;

public class LauncherActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);

		final String[] values = getResources().getStringArray(
				R.array.launcher_items);

		final String[] urls = getResources().getStringArray(
				R.array.launcher_urls);

		final Airpush airpush = new Airpush(getApplicationContext());
		((Button) findViewById(R.id.launcher_button_ads))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						airpush.startSmartWallAd();

					}
				});

		ListView listView = getListView();
		final Typeface type = Typeface.createFromAsset(getAssets(),
				"fonts/Snickles.ttf");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.activity_launcher_item, values) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);

				TextView textView = (TextView) view
						.findViewById(R.id.activity_launcher_item_text);

				textView.setTypeface(type);

				return view;
			}
		};

		listView.setCacheColorHint(0);

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				final Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(urls[position]));
				startActivity(intent);
			}
		});

	}
}
