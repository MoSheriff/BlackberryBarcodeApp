package main.java.com.owfg.facade.bb.StoreManagement.gui;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.MainScreen;

public final class HistoryScreen extends MainScreen {
	/**
	 * Creates a new MyScreen object
	 */
	public HistoryScreen() {
		super();
		LabelField title = new LabelField("History Sample", LabelField.ELLIPSIS
				| LabelField.USE_ALL_WIDTH);
		setTitle(title);
		add(new RichTextField("HISTORY \n-------------"));
	}
}
