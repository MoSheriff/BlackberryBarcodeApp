// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package main.java.com.owfg.facade.bb.StoreManagement.stub;


public class GetStoreManagementInfo {
    protected long storeId;
    protected java.lang.String upc;
    
    public GetStoreManagementInfo() {
    }
    
    public GetStoreManagementInfo(long storeId, java.lang.String upc) {
        this.storeId = storeId;
        this.upc = upc;
    }
    
    public long getStoreId() {
        return storeId;
    }
    
    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
    
    public java.lang.String getUpc() {
        return upc;
    }
    
    public void setUpc(java.lang.String upc) {
        this.upc = upc;
    }
}
