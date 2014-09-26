/**
 * 
 */
package Writer;

import DataModel.entryModel;

/**
 * @author gidakash
 *
 */
public class systemWriter implements writer{

	@Override
	public void writeEntry(entryModel model) {
		// TODO Auto-generated method stub
		System.out.println(model.getCompanyName().toString());
		System.out.println("You have to hold: "+model.getTermToHold() + "Years");
		System.out.println("IntrensicValue: "+ model.getIntrinsicValue());
		System.out.println(model.getBuyNoBuy());
		System.out.println("PresentValue: "+ model.getPrice());
		System.out.println("URL: " + model.getURL());
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Output writer closed");
	}
}
