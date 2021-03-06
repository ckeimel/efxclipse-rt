/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.snippets;

/*
 * SashForm example snippet: create a sash form with three children
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet109 implements SWTAppStart {

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		SashForm form = new SashForm(shell, SWT.HORIZONTAL);
		form.setLayout(new FillLayout());

		Composite child1 = new Composite(form, SWT.NONE);
		child1.setLayout(new FillLayout());
		new Label(child1, SWT.NONE).setText("Label in pane 1");

		Composite child2 = new Composite(form, SWT.NONE);
		child2.setLayout(new FillLayout());
		new Button(child2, SWT.PUSH).setText("Button in pane2");

		Composite child3 = new Composite(form, SWT.NONE);
		child3.setLayout(new FillLayout());
		new Label(child3, SWT.PUSH).setText("Label in pane3");

		form.setWeights(new int[] { 30, 40, 30 });
		SWTUtil.getInstance().openBlocking(shell);
		return null;
	}
	
	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet109());
	}
}
