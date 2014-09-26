/**
 * 
 */
package Render;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.commons.httpclient.NameValuePair;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DataModel.GeneralFundamentalValueDataModel;
import Mapper.MCMapperImpl;
import Mapper.Mapper;

/**
 * @author gidakash
 * This is for Screener.in rendering.
 */
public class screenRender extends render{

	private static NameValuePair fundamentalValuesTag = new NameValuePair("class", "FR gD_12"); 
	private static NameValuePair currentPriceTag      = new NameValuePair("id", "Bse_Prc_tick");
	private static NameValuePair companyNameTag       = new NameValuePair("class", "b_42");

	static Mapper map = new MCMapperImpl();
	@Override
	public GeneralFundamentalValueDataModel render(String url) {
		
		final ArrayList<String> holder= new ArrayList<String>();
		GeneralFundamentalValueDataModel fundamentals = new GeneralFundamentalValueDataModel();
		
		Document doc = null;
		try {
			doc = curlWebPage("http://www.screener.in/company/?q=532855");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	         Element tableElements = doc.getElementById("price");
	         System.out.println("Value is : " + tableElements.toString());

//	         Elements tableHeaderEles = tableElements.select("thead tr th");
//	         System.out.println("headers");
//	         for (int i = 0; i < tableHeaderEles.size(); i++) {
//	            System.out.println(tableHeaderEles.get(i).text());
//	         }
//	         System.out.println();
//
//	         Elements tableRowElements = tableElements.select(":not(thead) tr");
//
//	         for (int i = 0; i < tableRowElements.size(); i++) {
//	            Element row = tableRowElements.get(i);
//	            System.out.println("row");
//	            Elements rowItems = row.select("td");
//	            for (int j = 0; j < rowItems.size(); j++) {
//	               System.out.println(rowItems.get(j).text());
//	            }
//	            System.out.println();
//	         }
			return fundamentals;
		
		
		
		
		
//		Elements table = body.getElementsByAttributeValue(key, value)
//		Elements elements = body.getElementsByAttributeValue(fundamentalValuesTag.getName(), fundamentalValuesTag.getValue());
//		for(Element element : elements) {
//
//			holder.add(element.toString().substring(24, element.toString().length()-7));
//
//		}
//		Elements StockPrice = body.getElementsByAttributeValue(currentPriceTag.getName(), currentPriceTag.getValue());
//		holder.add(StockPrice.toString().substring(32, StockPrice.toString().length()-16));
//		map.map(fundamentals, holder);
//		Elements companyName = body.getElementsByAttributeValue(companyNameTag.getName(), companyNameTag.getValue());
//		fundamentals.setCompany(companyName.toString().substring(17, companyName.toString().length()-5));
//		return fundamentals;
//		
	}

}
