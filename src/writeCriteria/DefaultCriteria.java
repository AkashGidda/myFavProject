package writeCriteria;

import Calculations.Company;

public class DefaultCriteria implements WriteCriteria{

	@Override
	public boolean isRecordable(Company company) {
		// TODO Auto-generated method stub
		if ( company.isRealCompany())
			return true;
		else
			return false;
	}


}
