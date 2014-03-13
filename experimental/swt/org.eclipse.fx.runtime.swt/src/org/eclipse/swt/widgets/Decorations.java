package org.eclipse.swt.widgets;

import org.eclipse.swt.graphics.Image;

public class Decorations extends Canvas {
	private Button defaultButton;
	private String text;
	private Image image;
	private boolean minimized;
	private boolean maximized;
	private Image[] images;
	private Menu menuBar;
	
	public Decorations(Display display, int style) {
		super(display, style);
	}

	public void setText(String string) {
		this.text = string;
	}
	
	public String getText() {
		return this.text;
	}
	
	public Image getImage () {
		return this.image; 
	}
	
	public void setImage (Image image) {
		this.image = image;
	}
	
	public void setDefaultButton(Button defaultButton) {
		this.defaultButton = defaultButton;
	}
	
	public Button getDefaultButton() {
		return defaultButton;
	}
	
	public Image [] getImages () {
		return this.images;
	}
	
	public boolean getMaximized () {
		return maximized;
	}
	
	public Menu getMenuBar () {
		return menuBar;
	}
	
	public boolean getMinimized () {
		return this.minimized;
	}
	
	public void setImages (Image [] images) {
		this.images = images;
	}
	
	public void setMaximized (boolean maximized) {
		this.maximized = maximized;
	}
	
	public void setMenuBar (Menu menu) {
		this.menuBar = menu;
	}
	
	public void setMinimized (boolean minimized) {
		this.minimized = minimized;
	}
}