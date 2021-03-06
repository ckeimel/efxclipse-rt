package org.eclipse.fx.runtime.swtutil;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

final class SWTNativeUtil extends SWTUtil {
	public void bootstrap(SWTAppStart runnable) {
		Display d = new Display();
		BlockCondition condition = runnable.createApp(d);
		if( condition != null ) {
			block(d, condition);
		}
		d.dispose();
	}
	
	public void openBlocking(Shell shell) {
		shell.open();
		block(shell.getDisplay(), new ShellBlockCondition(shell));
	}
	
	public void block(Display d, BlockCondition condition) {
		DefaultBlockCondition fCondition = (DefaultBlockCondition) condition;
		while( fCondition.isBlocked() ) {
			if( !d.readAndDispatch() ) {
				d.sleep();
			}
		}
	}
	
	@Override
	public BlockCondition createShellBlockCondition(Shell shell) {
		return new ShellBlockCondition(shell);
	}
	
	@Override
	public BlockCondition createSimpleBlockCondition() {
		return new DefaultBlockCondition();
	}
	
	public static class ShellBlockCondition extends DefaultBlockCondition {
		private Shell shell;
		
		public ShellBlockCondition(Shell shell) {
			this.shell = shell;
		}
		
		@Override
		public boolean isBlocked() {
			return super.isBlocked() && ! shell.isDisposed();
		}
	}
	
	public static class DefaultBlockCondition extends BlockCondition {
		private boolean blocked = true;
		
		public final synchronized void unblock() {
			this.blocked = false;
		}
		
		public synchronized boolean isBlocked() {
			return blocked;
		}
	}
}