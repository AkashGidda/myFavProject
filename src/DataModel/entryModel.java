package DataModel;

public class entryModel {

	String companyName;
	String buyNoBuy;
	double TermToHold;
	double price;
	double intrinsicValue;
	String URL;
	
	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}
	/**
	 * @return the intrinsicValue
	 */
	public double getIntrinsicValue() {
		return intrinsicValue;
	}
	/**
	 * @param intrinsicValue the intrinsicValue to set
	 */
	public void setIntrinsicValue(double intrinsicValue) {
		this.intrinsicValue = intrinsicValue;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the buyNoBuy
	 */
	public String getBuyNoBuy() {
		return buyNoBuy;
	}
	/**
	 * @param buyNoBuy the buyNoBuy to set
	 */
	public void setBuyNoBuy(String buyNoBuy) {
		this.buyNoBuy = buyNoBuy;
	}
	/**
	 * @return the termToHold
	 */
	public double getTermToHold() {
		return TermToHold;
	}
	/**
	 * @param termToHold the termToHold to set
	 */
	public void setTermToHold(double termToHold) {
		TermToHold = termToHold;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
