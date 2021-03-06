/*
 * Copyright (c) 2009-2011. Created by serso aka se.solovyev.
 * For more information, please, contact se.solovyev@gmail.com
 * or visit http://se.solovyev.org
 */

package org.solovyev.android.calculator.help;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.solovyev.android.AndroidUtils;
import org.solovyev.android.LastTabSaver;
import org.solovyev.android.calculator.R;

/**
 * User: serso
 * Date: 11/19/11
 * Time: 11:35 AM
 */
public class CalculatorHelpTabActivity extends TabActivity {

	@Nullable
	private LastTabSaver lastTabSaver;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tabs);

		final TabHost tabHost = getTabHost();

		createTab(tabHost, "faq", R.string.c_faq, HelpFaqActivity.class);
		createTab(tabHost, "hints", R.string.c_hints, HelpHintsActivity.class);
		createTab(tabHost, "screens", R.string.c_screens, HelpScreensActivity.class);

		this.lastTabSaver = new LastTabSaver(this, "faq");

		AndroidUtils.centerAndWrapTabsFor(tabHost);
	}

	private void createTab(@NotNull TabHost tabHost,
						   @NotNull String tabId,
						   int tabCaptionId,
						   @NotNull Class<? extends Activity> activityClass) {

		TabHost.TabSpec spec;

		final Intent intent = new Intent().setClass(this, activityClass);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost.newTabSpec(tabId).setIndicator(getString(tabCaptionId)).setContent(intent);

		tabHost.addTab(spec);
	}

	@Override
	protected void onDestroy() {
		if (this.lastTabSaver != null) {
			this.lastTabSaver.destroy();
		}

		super.onDestroy();
	}
}
