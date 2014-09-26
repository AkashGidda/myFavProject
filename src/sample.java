import writeCriteria.BuyWriteCriteria;
import writeCriteria.DefaultCriteria;
import Controller.controller;
import Controller.massRunController;
import Reader.clipBoardReader;
import Writer.fileWriter;
import Writer.systemWriter;

/**
 * 
 */

/**
 * @author gidakash
 *
 */
public class sample {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		massRunController mainController = new massRunController(new clipBoardReader(), new fileWriter(), new BuyWriteCriteria());
		mainController.init();
	}
}
