package main.java.com.owfg.facade.bb.StoreManagement.gui;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.WebService.WebService;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Banner;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class WebServiceScreen extends MainScreen {
	public WebServiceScreen() {
		Store[] si = null;
		Banner[] banners = null;
		StoreManagementInfo productInfo;
		
		WebService ws = new WebService();
		//testing get store ID
		try {
			si = ws.getStores();
		} catch (Exception e) {
			Logger.logErrorEvent("WebServiceScreen() getStores(): " + e);
			return;
		}
		for (int i = 0; i != si.length; ++i) {
			add(new LabelField("Name: " + si[i].getStoreName() + " Id: " + si[i].getStoreId()));
		}
		//testing banners
		try {
			banners = ws.getBanners();
		} catch (Exception e) {
			Logger.logErrorEvent("WebServiceScreen() getBanners(): " + e);
			return;
		}
		
		for (int i = 0; i != banners.length; ++i) {
			add(new LabelField("Banner: " + banners[i].getBannerName() + " Id: " + banners[i].getBannerId()));
		}
		//testing info
		try {
			productInfo = ws.getInfo("1234");
		} catch (Exception e) {
			Logger.logErrorEvent("WebServiceScreen() getInfo(): " + e);
			return;
		}
		add(new LabelField("Product Desc: " + productInfo.getItemDescription()));
		add(new LabelField("Product Price: " + productInfo.getRegularPrice()));
	}

}
