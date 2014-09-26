/**
 * 
 */
package Mapper;

import java.util.ArrayList;



import DataModel.GeneralFundamentalValueDataModel;

/**
 * @author gidakash
 *
 */
public class MCMapperImpl implements Mapper{

	@Override
	public void map(GeneralFundamentalValueDataModel generalFundamentalValueDataModel, ArrayList<String> FundamentalValues) {
		generalFundamentalValueDataModel.setCapital(getValue(FundamentalValues, 0));
		generalFundamentalValueDataModel.setPe(getValue(FundamentalValues, 1));
		generalFundamentalValueDataModel.setBookValue(getValue(FundamentalValues, 2));
		generalFundamentalValueDataModel.setDiv(getValue(FundamentalValues, 3));
		generalFundamentalValueDataModel.setMarketLot(getValue(FundamentalValues, 4));
		generalFundamentalValueDataModel.setIndustryPE(getValue(FundamentalValues, 5));
		generalFundamentalValueDataModel.setEps(getValue(FundamentalValues, 6));
		generalFundamentalValueDataModel.setPc(getValue(FundamentalValues, 7));
		generalFundamentalValueDataModel.setPriceByBook(getValue(FundamentalValues, 8));
		generalFundamentalValueDataModel.setDivYeild(getValue(FundamentalValues, 9));
		generalFundamentalValueDataModel.setFaceValue(getValue(FundamentalValues, 10));
		generalFundamentalValueDataModel.setPrice(getValue(FundamentalValues, 11));
	}

	public double getValue(ArrayList<String> fundamentalValues, int index) {
		if(getDelimetedString(fundamentalValues.get(index)).isEmpty()) 
			return 0.00;
		else
			return Double.parseDouble(getDelimetedString(fundamentalValues.get(index)));
	}

	public String getDelimetedString(String value) {	
		return value.replaceAll("[, % -]", "");
	}


}
