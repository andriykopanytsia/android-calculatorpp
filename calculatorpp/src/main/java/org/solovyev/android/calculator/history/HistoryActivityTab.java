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
 * Time: 7:39 PM
 */
public class HistoryActivityTab extends AbstractHistoryActivity {
	@Override
	protected int getLayoutId() {
		return R.layout.history;
	}

	@NotNull
	@Override
	protected List<CalculatorHistoryState> getHistoryItems() {
		return new ArrayList<CalculatorHistoryState>(CalculatorHistory.instance.getStates());
	}

	@Override
	protected void clearHistory() {
		CalculatorHistory.instance.clear();
		getAdapter().clear();
	}
}
