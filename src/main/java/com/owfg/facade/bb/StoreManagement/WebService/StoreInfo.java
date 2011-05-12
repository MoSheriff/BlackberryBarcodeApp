package main.java.com.owfg.facade.bb.StoreManagement.WebService;
import main.java.com.owfg.facade.bb.StoreManagement.stub.Store;

public class StoreInfo {
	public String name;
	public long id;
	
	public StoreInfo(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public StoreInfo(Store st) {
		name = st.getStoreName();
		id = st.getStoreId();
	}
}
