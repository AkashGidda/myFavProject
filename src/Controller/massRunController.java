/**
 * 
 */
package Controller;

import writeCriteria.WriteCriteria;
import Calculations.Company;
import Calculations.CompanyImpl;
import DataModel.entryModel;
import Reader.reader;
import Render.mc_render;
import Writer.writer;

/**
 * @author gidakash
 *
 */
public class massRunController {

	private reader reader = null;
	private Writer.writer writer = null;
	private WriteCriteria criteria = null;

	public massRunController() {
	}

	public massRunController(reader reader){
		this.reader = reader;
	}

	public massRunController(reader reader, writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public massRunController(reader reader, writer writer, WriteCriteria criteria) {
		this.reader = reader;
		this.writer = writer;
		this.criteria =  criteria;
	}

	private void Run() {    
		int max = 525000;
		String URL = null;
		for (int i=500000; i<=max; i++) {				
			URL = "http://www.moneycontrol.com/stocks/cptmarket/compsearchnew.php?search_data=&cid=&mbsearch_str=&topsearch_type=1&search_str="+i;
			sendCompanyDetails(new CompanyImpl(URL, new mc_render()));
		}
		closeWriter();
	}

	private void sendCompanyDetails(Company company) {
		entryModel model = new entryModel();
		if( criteria.isRecordable(company) ) {	
			model.setBuyNoBuy(company.getBuyOrNoBuy());
			model.setCompanyName(company.showCompanyName().toString());
			model.setTermToHold(company.showYearsToHold());
			model.setIntrinsicValue(company.showIntrensicValue());
			model.setPrice(company.presentValue());
			model.setURL(company.getURL());
			
			writer.writeEntry(model);
		}

	}

	private void readSource() {
		reader.readSource();
	}

	private void closeWriter() {
		writer.close();
	}

	public void init() {
		readSource();
		Run();
	}
}

