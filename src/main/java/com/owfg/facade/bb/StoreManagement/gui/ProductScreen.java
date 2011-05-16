package main.java.com.owfg.facade.bb.StoreManagement.gui;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.WebService.ProductInfo;
import main.java.com.owfg.facade.bb.StoreManagement.WebService.WebService;
import main.java.com.owfg.facade.bb.StoreManagement.app.MyApp;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

public class ProductScreen extends MainScreen {
	private static WebService ws = null;
	private final int resultRows = 4;
	private final int resultCols = 2;
	private String upc = MyApp.resultText;
	private final int maxUPCLength = 20;
	private final int resultBoxLength = 7;
	private LabelField productName;
	private EditField boh, onOrder, min, inTransit, fcst, pack, reg, source;
	private ProductInfo productInfo;

	/**
	 * Constructor for the product screen Sets the layout of all the different
	 * fields
	 * 
	 * @author Marcel Vangrootheest
	 */
	public ProductScreen() {
		super();
		MyApp.resultText = "";
		VerticalFieldManager vfm = new VerticalFieldManager(USE_ALL_WIDTH);

		// Fields for a form
		VerticalFieldManager form = new VerticalFieldManager(FIELD_HCENTER);
		form.setMargin(10, 20, 10, 20);
		EditField upcField = new EditField("UPC: ", upc, maxUPCLength,
				FIELD_LEFT);
		form.add(upcField);
		form.add(new ObjectChoiceField("Store: ", WebServiceActiveStores(), 0));
		vfm.add(form);

		productName = new LabelField("", LabelField.ELLIPSIS | FIELD_HCENTER);
		vfm.add(productName);

		// Result grid
		GridFieldManager grid = new GridFieldManager(resultRows, resultCols,
				GridFieldManager.FIXED_SIZE | FIELD_HCENTER);

		boh = new EditField("BOH: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(boh);
		onOrder = new EditField("On Order: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(onOrder);
		min = new EditField("Min: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(min);
		inTransit = new EditField("In Transit: ", "", resultBoxLength,
				FIELD_RIGHT | READONLY);
		grid.add(inTransit);
		fcst = new EditField("Fcst: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(fcst);
		pack = new EditField("Pack: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(pack);
		reg = new EditField("Reg: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(reg);
		source = new EditField("Source: ", "", resultBoxLength, FIELD_RIGHT
				| READONLY);
		grid.add(source);

		grid.setColumnPadding(Display.getWidth() / 3);
		grid.setRowPadding(Display.getHeight() / 24);
		vfm.add(grid);
		add(vfm);
	}

	/**
	 * Creates a menu item
	 * <p>
	 * Reloads the camera screen and unloads the current screen
	 * 
	 * @author Marcel Vangrootheest
	 */
	public MenuItem scan = new MenuItem("Scan again", 100, 1) {
		public void run() {
			synchronized (MyApp.getEventLock()) {
				MyApp.app.popScreen(getScreen());
				MyApp.app.pushScreen(MyApp.cScreen);
			}
			MyApp.cScreen.startThread();
		}
	};

	/**
	 * Creates a menu item
	 * <p>
	 * calls the function to load the function fields
	 * 
	 * @author Warren Voelkl
	 */
	public MenuItem submit = new MenuItem("Submit", 100, 1) {
		public void run() {
			if (WebserviceRecieveInfoByUPC()) {
				setProductFields();
			} else {
				// TODO remove code below and display exception dialog
				productName.setText("Failed results");
				boh.setText("6");
				onOrder.setText("1");
				min.setText("2");
				inTransit.setText("1");
				fcst.setText("4.3");
				pack.setText("6");
				reg.setText("$4.99");
				source.setText("DSD");
			}
		}
	};

	/**
	 * Calls the web service class and retrieves a product info object
	 * <p>
	 * 
	 * @return false on failure true on success
	 * @author Warren Voelkl
	 */
	public boolean WebserviceRecieveInfoByUPC() {
		//ProductInfo info = null;
		if (ws == null) {
			ws = new WebService();
		}
		try {
			productInfo = ws.getInfo(upc);
		} catch (Exception e) {
			synchronized(MyApp.app.getEventLock()) {
				Dialog.inform("Failed to contact WebService");
			}
			Logger.logSevereErrorEvent("WebserviceRecieveInfoByUPC(): " + e);
			return false;
		}
		return true;

	}

	/**
	 * Gets a list of stores from server
	 * @return a list of stores 
	 */
	private String[] WebServiceActiveStores() {
		String[] str = null;
		if (ws == null) {
			ws = new WebService();
		}
		try {
			str = ws.getStores();
		} catch (Exception e) {
			synchronized(MyApp.app.getEventLock()) {
				Dialog.inform("Failed to contact WebService");
			}
			Logger.logErrorEvent("ProductScreen.getStores(): " + e);
			//TODO sort this out
			str = new String[1];
			String blank = new String("");
			str[0] = blank;
			return str;
		}
		return str;
	}

	public MenuItem quit = new MenuItem("Exit", 100, 1) {
		public void run() {
			if (Dialog.ask(Dialog.D_YES_NO, "Exit?") == 4) {
				System.exit(0);
			}
		}
	};
	/**
	 * TODO remove on final release
	 */
	public MenuItem WebServiceTest = new MenuItem("WebService Test", 100, 1) {
		public void run() {
			// MyApp.app.popScreen(getScreen());
			MyApp.app.pushScreen(new WebServiceScreen());
		}
	};

	/**
	 * Creates a menu to select options. TODO remove WebSerrivceTest on final
	 * release
	 * 
	 * @author Mo, Warren Voelkl
	 */
	public void makeMenu(Menu menu, int instance) {
		menu.add(WebServiceTest);
		menu.add(scan);
		menu.add(submit);
		menu.add(quit);
	}

	public boolean onSavePrompt() {
		return true;
	}

	/**
	 * Sets the product files from a productInfo object.
	 * 
	 * @author Warren Voelkl
	 */
	private void setProductFields() {
		if (productInfo == null) {
			return; //maybe display error screen?
		}
		productName.setText(productInfo.itemDesc);
		boh.setText(productInfo.boh);
		onOrder.setText(productInfo.onOrder);
		min.setText(productInfo.min);
		inTransit.setText(productInfo.inTransit);
		fcst.setText(productInfo.forcast);
		pack.setText(productInfo.pack);
		reg.setText(productInfo.regularPrice);
		source.setText(productInfo.source);
	}
}
