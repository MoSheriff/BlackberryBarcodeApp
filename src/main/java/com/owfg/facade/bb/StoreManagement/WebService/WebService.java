package main.java.com.owfg.facade.bb.StoreManagement.WebService;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Banner;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementImpl_Stub;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo;



public class WebService  {
	private static StoreManagementImpl_Stub stub = null;
	public WebService() {
		Logger.logDebugEvent("WebService(): entered");
		try {
			if (stub == null) {
				//here we should be parsing an external file to set the endpoint address
				stub = new StoreManagementImpl_Stub();
				stub._setProperty(StoreManagementImpl_Stub.ENDPOINT_ADDRESS_PROPERTY,
						"http://warrenv.dlinkddns.com:8080");
				if (stub == null) {
					Logger.logErrorEvent("stub null after fetching it");
				} else {
					Logger.logDebugEvent("WebService() stub not null");
				}
			}
		} catch (Exception ex) {
			Logger.logSevereErrorEvent("WebService(): " + ex);
			return;
		}
		Logger.logDebugEvent("WebService(): exit");
	}
	
	public Store[] getStores() throws Exception {
		Store[] storesResponse = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}		
		try {
			storesResponse = stub.getActiveStores();
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			storesResponse = new Store[1];
			Store store = new Store();
			store.setStoreId(12345);
			store.setStoreName("Fake Store");
			store.setBannerId(54321);
			storesResponse[0] = store;
			return storesResponse;
		}
		return storesResponse;
	}
	
	public Banner[] getBanners() throws Exception {
		Banner[] banners = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}
		try {
			banners = stub.getBanners();
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			banners = new Banner[1];
			Banner banner = new Banner();
			banner.setBannerId(11111);
			banner.setBannerName("bannerName");
			banners[0] = banner;
			return banners;
		}
		return banners;
	}
	
	public StoreManagementInfo getInfo(String str) throws Exception {
		StoreManagementInfo info = null;
		if (stub == null) {
			throw new Exception("Null Pointer Exception");
		}
		try {
			info = stub.getStoreManagementInfo(1,str);
		} catch (Exception e) {
			Logger.logSevereErrorEvent("WebService.getStores(): " + e);
			info = new StoreManagementInfo();
			info.setForecast(new Double(1));
			info.setBalanceOnHand(new Double(2));
			info.setInTransit(new Double(3));
			info.setItemDescription("SomeStuff");
			info.setMinimum(new Long(4));
			info.setOnOrder(new Double(5));
			info.setPack(new Integer(6));
			info.setPromotion("1 dollar off sale");
			info.setRegularPrice(new Double(101.99));
			info.setSource("no idea what this field means");
			info.setStoreId(12345);
			info.setUpc("1a2b3c4d");
			return info;
		}
		return info;
	}
}