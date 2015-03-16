package com.makingiants.googlelauncher;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by danielgomez22 on 3/15/15.
 */

public class LauncherApplication extends Application {

  @Override
  public void onCreate() {
	super.onCreate();
	CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
		.setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
		.setFontAttrId(R.attr.fontPath)
		.build()
	);
  }

}


