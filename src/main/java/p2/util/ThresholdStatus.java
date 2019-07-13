package p2.util;

public enum ThresholdStatus {
	
	WITHIN_THRESHOLD("Within Threshold"),
	NEVER_SURPASSED_THRESHOLD("Never Surpassed Threshold"),
	CANCELLED_BY_SELLER("Cancelled By Seller"),
	ON_SALE("On Sale"),
	STANDARD("Standard");
	
	public final String value;
	
	private ThresholdStatus( String value) {
		this.value = value;
	}


}
