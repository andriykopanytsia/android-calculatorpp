/*
 * Copyright (c) 2009-2011. Created by serso aka se.solovyev.
 * For more information, please, contact se.solovyev@gmail.com
 * or visit http://se.solovyev.org
 */

package org.solovyev.android.calculator.history;

import org.jetbrains.annotations.NotNull;
import org.solovyev.android.calculator.R;

import java.util.ArrayList;
import java.util.List;

/**
 * User: serso
 * Date: 12/18/11
 * Time: 7:40 PM
 */
public class SavedHistoryActivityTab extends AbstractHistoryActivity {
	@Override
	protected int getLayoutId() {
		return R.layout.saved_history;
	}

	@NotNull
	@Override
	protected List<CalculatorHistoryState> getHistoryItems() {
		return new ArrayList<CalculatorHistoryState>(CalculatorHistory.instance.getSavedHistory());
	}

	@Override
	protected void clearHistory() {
		CalculatorHistory.instance.clearSavedHistory(this);
		getAdapter().clear();
	}
}
