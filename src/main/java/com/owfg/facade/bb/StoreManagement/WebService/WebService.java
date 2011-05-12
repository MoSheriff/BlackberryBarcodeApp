package main.java.com.owfg.facade.bb.StoreManagement.WebService;

import main.java.com.owfg.facade.bb.StoreManagement.Logger.Logger;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Banner;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementImpl_Stub;
import main.java.com.owfg.facade.bb.StoreManagement.stub.StoreManagementInfo;


/**
* Class which manages the web service.
* <p>
* The WebService uses the generated stub files then sets the
* target server address in the stub classes from the properties file
* (to be implemented)   
*
* @author Warren Voelkl
**/
public class WebService  {
	private static StoreManagementImpl_Stub stub = null;
	public WebService() {
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
	}
	
	/**
	* Gets a list of the stores from server
	* <p>
	* Currently this function uses the stub to contact a server
	* on a failure it will throw an exception currently this is
	* disabled for testing purposes.
	*
	* @return a list of stores containing name, id and bannerId
	* @author Warren Voelkl
	**/
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
	
	/**
	* Gets a list of the Banners from server
	* <p>
	* Currently this function uses the stub to contact a server
	* on a failure it will throw an exception currently this is
	* disabled for testing purposes.
	*
	* @return a list of store banners;
	* @author Warren Voelkl
	**/
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
	
	/**
	* Gets a list of the Banners from server
	* <p>
	* Currently this function uses the stub to contact a server
	* on a failure it will throw an exception currently this exception
	* returns bogus data for testing purposes.
	* 
	* @return the info object containing all information of an object
	* @author Warren Voelkl
	**/	
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
			info.setSource("dfd ?");
			info.setStoreId(12345);
			info.setUpc("1a2b3c4d");
			return info;
		}
		return info;
	}
}