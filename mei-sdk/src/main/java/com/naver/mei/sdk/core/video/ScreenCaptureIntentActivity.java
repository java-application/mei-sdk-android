/*
Copyright 2018 NAVER Corp.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.naver.mei.sdk.core.video;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.naver.mei.sdk.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ScreenCaptureIntentActivity extends Activity {
	private static final int REQUSET_CODE = 333;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_capture_intent);

		MediaProjectionManager manager = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);
		startActivityForResult(manager.createScreenCaptureIntent(), REQUSET_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ScreenCaptureIntent.resultCode = resultCode;
		ScreenCaptureIntent.resultData = data;
		finish();
	}
}
