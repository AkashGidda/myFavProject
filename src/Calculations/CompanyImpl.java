/**
 * 
 */
package Calculations;

import Constants.businessConstants;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DataModel.GeneralFundamentalValueDataModel;
import Mapper.MCMapperImpl;
import Mapper.Mapper;
import Render.basicRender;
import Render.render;


/**
 * @author gidakash
 *
 */
public class CompanyImpl implements Company{
	
	private GeneralFundamentalValueDataModel fundamentals = new GeneralFundamentalValueDataModel();
	ArrayList<Double> yearWiseIntrensicValue = new ArrayList<Double>();
	private String companyName;
	private String URL;

	/**
	 * @return the uRL
	 */
	@Override
	public String getURL() {
		return URL;
	}

	private String buyNoBuy;
	private double yearsToHold;
	private Double equityGrowthRate;
	private Double IntrensicValue;
	private basicRender render;
	private boolean isRealCompany = true;
	
	public CompanyImpl(String uRL, basicRender render) {
		this.URL = uRL;
		this.render = render;
		init();
	}

	/**
	 * @return the fundamentals
	 */
	public GeneralFundamentalValueDataModel getFundamentals() {
		return fundamentals;
	}

	private void calcIntrinsicVal() {
		double intrensicValue = fundamentals.getBookValue();
		for(int i=1;i<30;i++) {			
			yearWiseIntrensicValue.add(intrensicValue);
			intrensicValue = intrensicValue*(1+equityGrowthRate);
		}
	}

	public void showIntrensicValues() {
		for(Double intrensicValue : yearWiseIntrensicValue)
		System.out.println(intrensicValue.doubleValue());
		
	}

	public double calcRateOfGrowthPercentage() {
		return (fundamentals.getEps()/fundamentals.getBookValue());		
	}


	public void giveBuyNoBuyCall() {
		// TODO Auto-generated method stub
		buyNoBuy = (yearWiseIntrensicValue.get(10) < fundamentals.getPrice()*Math.pow((1 + (businessConstants.INTEREST_RATE/100)), businessConstants.EXPECTED_HOLDING))? "noBuy" : "Buy";
		//System.out.println("It is better to " + buyNoBuy + " at this price of " + fundamentals.getPrice());
	
	}


	public void yearsToHoldWithPresentPriceBuyCall() {
		// TODO Auto-generated method stub
		yearsToHold =  Math.log((fundamentals.getPrice()/fundamentals.getBookValue()))/Math.log((1+equityGrowthRate)/(1 + (businessConstants.INTEREST_RATE/100)));
		
	}
	
	public void init() {
		
		extractInfoFromWeb();
		if (fundamentals != null) {
		setNameForCompany();
		equityGrowthRate = calcRateOfGrowthPercentage();
		calcIntrinsicVal();
		yearsToHoldWithPresentPriceBuyCall();
		giveBuyNoBuyCall();
		}
	}
	
	private void setNameForCompany() {
		// TODO Auto-generated method stub
		this.companyName = fundamentals.getCompany();
	}
	@Override
	public String showCompanyName() {
		// TODO Auto-generated method stub
		return companyName;
	}
	@Override
	public double showYearsToHold() {
		// TODO Auto-generated method stub
		//System.out.println("You have to hold: " + yearsToHold + " years.");
		return yearsToHold;
	}
	@Override
	public String getBuyOrNoBuy(){
		return buyNoBuy;
	}

	private void extractInfoFromWeb(){
		fundamentals = render.render(URL);
		if (fundamentals == null ) {
			isRealCompany = false;
		}
	}
		

	@Override
	public Double showIntrensicValue() {
		// TODO Auto-generated method stub
		IntrensicValue = yearWiseIntrensicValue.get(10)/Math.pow(((1 + businessConstants.INTEREST_RATE/100)), businessConstants.EXPECTED_HOLDING);				
		//System.out.println("Intrensic Value is: " + IntrensicValue);
		return IntrensicValue;
	}

	@Override
	public double presentValue() {
		// TODO Auto-generated method stub
		return fundamentals.getPrice();
	}

	@Override
	public boolean isRealCompany() {
		// TODO Auto-generated method stub
		return isRealCompany;
	}

}
