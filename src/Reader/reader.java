/**
 * 
 */
package Reader;

/**
 * @author gidakash
 * This is an interface of reader.
 */
public interface reader {
	
	// Will read source and returns the numbers of URLs read.
	public int readSource();
	// Will return the URL based on index.
	public String giveURL(int Index);
	// will return the size of the URLs
	public int getSize();
}
