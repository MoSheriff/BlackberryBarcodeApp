package main.java.com.owfg.facade.bb.StoreManagement.gui;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.WebService.WebService;
import main.java.com.owfg.facade.bb.StoreManagement.app.MyApp;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo;
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
	private StoreManagementInfo productInfo;
	
	/**
	 * Constructor for the product screen
	 * Sets the layout of all the different fields
	 * @author Marcel Vangrootheest, Warren Voelkl
	 */
	public ProductScreen() {
		super();
		MyApp.resultText = "";
		VerticalFieldManager vfm = new VerticalFieldManager(USE_ALL_WIDTH);
		
		//Fields for a form
		VerticalFieldManager form = new VerticalFieldManager(FIELD_HCENTER);
		form.setMargin(10, 50, 10, 50);
		EditField upcField = new EditField("UPC: ", upc, maxUPCLength, FIELD_LEFT);
		form.add(upcField);
		form.add(new ObjectChoiceField("Store: ", getStores(), 0));
		vfm.add(form);
		
		productName = new LabelField("", LabelField.ELLIPSIS | FIELD_HCENTER);
		vfm.add(productName);
		
		//Result grid
		GridFieldManager grid = new GridFieldManager(resultRows, resultCols,
				GridFieldManager.FIXED_SIZE | FIELD_HCENTER);
		
		boh = new EditField("BOH: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(boh);
		onOrder = new EditField("On Order: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(onOrder);
		min = new EditField("Min: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(min);
		inTransit = new EditField("In Transit: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(inTransit);
		fcst = new EditField("Fcst: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(fcst);
		pack = new EditField("Pack: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(pack);
		reg = new EditField("Reg: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(reg);
		source = new EditField("Source: ", "", resultBoxLength, FIELD_RIGHT | READONLY);
		grid.add(source);
		
		grid.setColumnPadding(100);
		grid.setRowPadding(10);
		vfm.add(grid);
		add(vfm);
	}
	
	/**
	 * 
	 * @return a list of stores
	 */
    private String[] getStores() {
    	String[] s = null;//s = 
    	Store[] recieveStores = null;
    	if (ws == null) {
    		ws = new WebService();
    	}
    	try {
			recieveStores = ws.getStores();
		} catch (Exception e) {
			//TODO Dialog.something(Dialog.D_YES_NO, "Exit?") == 4
			Logger.logErrorEvent("ProductScreen.getStores(): " + e);
			String[] fail = {"918 Fleetwood", "930 Maple Ridge"};
			return fail;
		}
		s = new String[recieveStores.length];
		for (int i = 0; i != recieveStores.length; i++) {
			s[i] = new String(recieveStores[i].getStoreId()  //might want this to be bannerID
					+ " " + recieveStores[i].getStoreName());
		}
		return s;
	}

	public MenuItem scan = new MenuItem("Scan again", 100, 1) {
		public void run() {
			synchronized (MyApp.getEventLock()) {
				MyApp.app.popScreen(getScreen());
				MyApp.app.pushScreen(MyApp.cScreen);
			}
			MyApp.cScreen.startThread();
		}
	};

    public MenuItem submit = new MenuItem("Submit", 100, 1) {
		public void run() {
			if (WebserviceRecieveInfoByUPC()) {
				setProductFields();
			} else {
				//bogus results for testing
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

		public boolean WebserviceRecieveInfoByUPC() {
			
			if (ws == null) {
				ws = new WebService();
			}
			try {
				//TODO dialog box on fail
				productInfo = ws.getInfo(upc);
			} catch (Exception e) {
				Logger.logSevereErrorEvent("WebserviceRecieveInfoByUPC(): " + e);
				return false;
			}
			return true;
			
		}
	};
	
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
    public MenuItem WebServiceTest = new MenuItem("WebService Test",100, 1) {
		public void run() {
			//MyApp.app.popScreen(getScreen());
			MyApp.app.pushScreen(new WebServiceScreen());
		}
	};  
	
	/**
	 * Creates a menu to select options.
	 * TODO remove WebSerrivceTest on final release
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
	 * @author Warren Voelkl
	 */
	private void setProductFields() {
		productName.setText(productInfo.getItemDescription());
		boh.setText(productInfo.getBalanceOnHand().toString());
		onOrder.setText(productInfo.getOnOrder().toString());
		min.setText(productInfo.getMinimum().toString());
		inTransit.setText(productInfo.getInTransit().toString());
		fcst.setText(productInfo.getForecast().toString());
		pack.setText(productInfo.getPack().toString());
		reg.setText(productInfo.getRegularPrice().toString());
		source.setText(productInfo.getSource().toString());
	}
}
