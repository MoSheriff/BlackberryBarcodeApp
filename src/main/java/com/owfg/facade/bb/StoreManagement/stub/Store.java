// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package main.java.com.owfg.facade.bb.StoreManagement.stub;


public class Store {
    protected long bannerId;
    protected long storeId;
    protected java.lang.String storeName;
    
    public Store() {
    }
    
    public Store(long bannerId, long storeId, java.lang.String storeName) {
        this.bannerId = bannerId;
        this.storeId = storeId;
        this.storeName = storeName;
    }
    
    public long getBannerId() {
        return bannerId;
    }
    
    public void setBannerId(long bannerId) {
        this.bannerId = bannerId;
    }
    
    public long getStoreId() {
        return storeId;
    }
    
    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
    
    public java.lang.String getStoreName() {
        return storeName;
    }
    
    public void setStoreName(java.lang.String storeName) {
        this.storeName = storeName;
    }
}
