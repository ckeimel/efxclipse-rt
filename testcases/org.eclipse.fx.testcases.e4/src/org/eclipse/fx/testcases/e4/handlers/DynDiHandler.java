package org.eclipse.fx.testcases.e4.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.menu.MItem;

@SuppressWarnings("restriction")
public class DynDiHandler {
	@CanExecute
	boolean canRun(@Named("test_2") @Optional Integer i) {
		return i != null && i.intValue() % 2 == 0;
	}
	
	@Execute
	void run(MItem item) {
		System.err.println("Running: " + item);
	}

}
