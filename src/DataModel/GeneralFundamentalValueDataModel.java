/**
 * 
 */
package DataModel;

/**
 * @author gidakash
 *
 */
public class GeneralFundamentalValueDataModel {
	private String company;
	private double capital;
	private double pe;
	private double bookValue;
	private double marketLot;
	private double industryPE;
	private double eps;
	private double pc;
	private double priceByBook;
	private double divYeild;
	private double div;
	private double faceValue;
	private double Price;
	private double deliverables;
	
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public double getPe() {
		return pe;
	}
	public void setPe(double pe) {
		this.pe = pe;
	}
	public double getBookValue() {
		return bookValue;
	}
	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}
	public double getMarketLot() {
		return marketLot;
	}
	public void setMarketLot(double marketLot) {
		this.marketLot = marketLot;
	}
	public double getIndustryPE() {
		return industryPE;
	}
	public void setIndustryPE(double industryPE) {
		this.industryPE = industryPE;
	}
	public double getEps() {
		return eps;
	}
	public void setEps(double eps) {
		this.eps = eps;
	}
	public double getPc() {
		return pc;
	}
	public void setPc(double pc) {
		this.pc = pc;
	}
	public double getPriceByBook() {
		return priceByBook;
	}
	public void setPriceByBook(double priceByBook) {
		this.priceByBook = priceByBook;
	}
	public double getDivYeild() {
		return divYeild;
	}
	public void setDivYeild(double divYeild) {
		this.divYeild = divYeild;
	}
	public double getDiv() {
		return div;
	}
	public void setDiv(double div) {
		this.div = div;
	}
	public double getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(double faceValue) {
		this.faceValue = faceValue;
	}
	public double getDeliverables() {
		return deliverables;
	}
	public void setDeliverables(double deliverables) {
		this.deliverables = deliverables;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeneralFundamentalValueDataModel [company=" + company
				+ ", capital=" + capital + ", pe=" + pe + ", bookValue="
				+ bookValue + ", marketLot=" + marketLot + ", industryPE="
				+ industryPE + ", eps=" + eps + ", pc=" + pc + ", priceByBook="
				+ priceByBook + ", divYeild=" + divYeild + ", div=" + div
				+ ", faceValue=" + faceValue + ", Price=" + Price
				+ ", deliverables=" + deliverables + "]";
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	
	

}
