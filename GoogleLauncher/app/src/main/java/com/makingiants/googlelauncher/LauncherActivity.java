package com.makingiants.googlelauncher;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LauncherActivity extends ListActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_launcher);

	if (BuildConfig.ADS_ENABLED) {
	  setContentView(R.layout.activity_launcher_with_ads);

	  AdRequest adRequest;
	  if (BuildConfig.DEBUG) {
		adRequest = new AdRequest.Builder().addTestDevice("027c6ee5571a8376").build();
	  } else {
		adRequest = new AdRequest.Builder().build();
	  }
	  AdView adView = ((AdView) findViewById(R.id.ear_ads));
	  adView.loadAd(adRequest);
	} else {
	  setContentView(R.layout.activity_launcher);
	}

	final Resources resources = getResources();
	final String[] values = resources.getStringArray(R.array.launcher_items);
	final String[] urls = resources.getStringArray(R.array.launcher_urls);

	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_launcher_item, values);

	ListView listView = getListView();
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

  //<editor-fold desc="For Calligraphy">

  @Override
  protected void attachBaseContext(Context newBase) {
	super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  //</editor-fold>

}
