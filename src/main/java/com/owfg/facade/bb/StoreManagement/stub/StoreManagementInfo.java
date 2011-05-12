// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JSR-172 Reference Implementation wscompile 1.0, using: JAX-RPC Standard Implementation (1.1, build R59)

package main.java.com.owfg.facade.bb.StoreManagement.stub;


public class StoreManagementInfo {
    protected java.lang.Double balanceOnHand;
    protected java.lang.Double forecast;
    protected java.lang.Double inTransit;
    protected java.lang.String itemDescription;
    protected java.lang.Long minimum;
    protected java.lang.Double onOrder;
    protected java.lang.Integer pack;
    protected java.lang.String promotion;
    protected java.lang.Double regularPrice;
    protected java.lang.String source;
    protected long storeId;
    protected java.lang.String upc;
    
    public StoreManagementInfo() {
    }
    
    public StoreManagementInfo(java.lang.Double balanceOnHand, java.lang.Double forecast, java.lang.Double inTransit, java.lang.String itemDescription, java.lang.Long minimum, java.lang.Double onOrder, java.lang.Integer pack, java.lang.String promotion, java.lang.Double regularPrice, java.lang.String source, long storeId, java.lang.String upc) {
        this.balanceOnHand = balanceOnHand;
        this.forecast = forecast;
        this.inTransit = inTransit;
        this.itemDescription = itemDescription;
        this.minimum = minimum;
        this.onOrder = onOrder;
        this.pack = pack;
        this.promotion = promotion;
        this.regularPrice = regularPrice;
        this.source = source;
        this.storeId = storeId;
        this.upc = upc;
    }
    
    public java.lang.Double getBalanceOnHand() {
        return balanceOnHand;
    }
    
    public void setBalanceOnHand(java.lang.Double balanceOnHand) {
        this.balanceOnHand = balanceOnHand;
    }
    
    public java.lang.Double getForecast() {
        return forecast;
    }
    
    public void setForecast(java.lang.Double forecast) {
        this.forecast = forecast;
    }
    
    public java.lang.Double getInTransit() {
        return inTransit;
    }
    
    public void setInTransit(java.lang.Double inTransit) {
        this.inTransit = inTransit;
    }
    
    public java.lang.String getItemDescription() {
        return itemDescription;
    }
    
    public void setItemDescription(java.lang.String itemDescription) {
        this.itemDescription = itemDescription;
    }
    
    public java.lang.Long getMinimum() {
        return minimum;
    }
    
    public void setMinimum(java.lang.Long minimum) {
        this.minimum = minimum;
    }
    
    public java.lang.Double getOnOrder() {
        return onOrder;
    }
    
    public void setOnOrder(java.lang.Double onOrder) {
        this.onOrder = onOrder;
    }
    
    public java.lang.Integer getPack() {
        return pack;
    }
    
    public void setPack(java.lang.Integer pack) {
        this.pack = pack;
    }
    
    public java.lang.String getPromotion() {
        return promotion;
    }
    
    public void setPromotion(java.lang.String promotion) {
        this.promotion = promotion;
    }
    
    public java.lang.Double getRegularPrice() {
        return regularPrice;
    }
    
    public void setRegularPrice(java.lang.Double regularPrice) {
        this.regularPrice = regularPrice;
    }
    
    public java.lang.String getSource() {
        return source;
    }
    
    public void setSource(java.lang.String source) {
        this.source = source;
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
