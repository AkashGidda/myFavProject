/**
 * 
 */
package Render;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author gidakash
 *
 */
public abstract class render implements basicRender{

	public static Document curlWebPage(String URL) throws URISyntaxException {
			// TODO Auto-generated method stub
			Document doc = null;
			try {
				doc = Jsoup.connect(URL).get();
			} catch (Exception e) {
				throw new URISyntaxException(URL, URL);
			}
			return doc;		
	}
}
