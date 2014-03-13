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
 * Text example snippet: set the selection (i-beam)
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.fx.runtime.swtutil.SWTUtil;
import org.eclipse.fx.runtime.swtutil.SWTUtil.BlockCondition;
import org.eclipse.fx.runtime.swtutil.SWTUtil.SWTAppStart;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet11 implements SWTAppStart {

	public static void main(String[] args) {
		SWTUtil.getInstance().bootstrap(new Snippet11());
	}

	@Override
	public BlockCondition createApp(Display display) {
		Shell shell = new Shell(display);
		Text text = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		Rectangle clientArea = shell.getClientArea();
		text.setBounds(clientArea.x + 10, clientArea.y + 10, 100, 100);
		for (int i = 0; i < 16; i++) {
			text.append("Line " + i + "\n");
		}
		shell.open();
		text.setSelection(30);
		System.out.println("selection=" + text.getSelection());
		System.out.println("caret position=" + text.getCaretPosition());
		System.out.println("caret location=" + text.getCaretLocation());
		return SWTUtil.getInstance().createShellBlockCondition(shell);
	}
}