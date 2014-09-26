/**
 * 
 */
package Reader;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * @author gidakash
 *
 */
public class clipBoardReader implements reader {
	String URL = null; 
	int size = 0;
	@Override
	public int readSource() {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		try {
			this.URL = (String) clipboard.getData(DataFlavor.stringFlavor);
			
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.size = 1;
		return size;
	}
	@Override
	public String giveURL(int Index) {
		// TODO Auto-generated method stub
		return URL;
	}
	public String giveURL(){
		return URL;
	}
	public int getSize(){
		return size;
	}
}
