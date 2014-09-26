/**
 * 
 */
package Writer;

import DataModel.entryModel;

/**
 * @author gidakash
 *
 */
public interface writer {

	public void writeEntry(entryModel entry);
	public void close();

}
