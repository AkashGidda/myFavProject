package Controller;
//Need to read data and write the required data some where.
// Controller need to know which read and which write implementation need to be used.

import writeCriteria.DefaultCriteria;
import writeCriteria.WriteCriteria;
import Calculations.Company;
import Calculations.CompanyImpl;
import DataModel.entryModel;
import Render.mc_render;
import Reader.reader;
import Writer.systemWriter;
import Writer.writer;

public class controller {

	private reader reader = null;
	private Writer.writer writer = new systemWriter();
	private WriteCriteria criteria = new DefaultCriteria();

	public controller() {
	}

	public controller(reader reader){
		this.reader = reader;
	}
	
	public controller(reader reader, writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public controller(reader reader, writer writer, WriteCriteria criteria) {
		this.reader = reader;
		this.writer = writer;
		this.criteria =  criteria;
	}
	
	private void Run() {    
		int max = reader.getSize();
		for (int i=1; i<=max; i++){	    	
			Company company = new CompanyImpl(reader.giveURL(i), new mc_render());
			sendCompanyDetails(company);
		}
		closeWriter();
	}

	private void sendCompanyDetails(Company company) {
		// TODO Auto-generated method stub
		entryModel model = new entryModel();
		if( criteria.isRecordable(company) ) {	
		model.setBuyNoBuy(company.getBuyOrNoBuy());
		model.setCompanyName(company.showCompanyName().toString());
		model.setTermToHold(company.showYearsToHold());
		model.setIntrinsicValue(company.showIntrensicValue());
		model.setPrice(company.presentValue());
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