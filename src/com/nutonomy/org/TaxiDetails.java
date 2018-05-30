package com.nutonomy.org;

/*
 * POJO containing details about Taxi
 */
public class TaxiDetails {
    private String taxiName;
    private int taxiId;
    private String customerName;
    private String taxiStatus;
    private Source pickup;
    private Destination drop;
    private int totalTime;
    private CurrentLocation currentLocation;
    
    public String getTaxiName() {
        return taxiName;
    }
    public void setTaxiName(String taxiName) {
        this.taxiName = taxiName;
    }
    public int getTaxiId() {
        return taxiId;
    }
    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }
    public String getTaxiStatus() {
        return taxiStatus;
    }
    public void setTaxiStatus(String taxiStatus) {
        this.taxiStatus = taxiStatus;
    }
    public Source getPickup() {
        return pickup;
    }
    public void setPickup(Source pickup) {
        this.pickup = pickup;
    }
    public Destination getDrop() {
        return drop;
    }
    public void setDrop(Destination drop) {
        this.drop = drop;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getTotalTime() {
        return totalTime;
    }
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
	public CurrentLocation getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(CurrentLocation currentLocation) {
		this.currentLocation = currentLocation;
	}
}
