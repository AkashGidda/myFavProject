/**
 * 
 */
package writeCriteria;

import Calculations.Company;
import Writer.writer;

/**
 * @author gidakash
 *
 */
public class BuyWriteCriteria implements WriteCriteria{

	@Override
	public boolean isRecordable(Company company) {
		if( company.isRealCompany() && company.getBuyOrNoBuy().equalsIgnoreCase("BUY"))
		return true;
		else
		return false;
	}

}
