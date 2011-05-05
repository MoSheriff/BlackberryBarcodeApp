package mypackage;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.MainScreen;

public final class HelpScreen extends MainScreen {
	/**
	 * Creates a new MyScreen object
	 */
	public HelpScreen() {
		super();
		LabelField title = new LabelField("Help Sample",
				LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);
		// Set the displayed title of the screen
		setTitle(title);
		add(new RichTextField("HELP"));
	}
}
