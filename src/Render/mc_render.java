package Render;

import java.util.ArrayList;

import org.apache.commons.httpclient.NameValuePair;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DataModel.GeneralFundamentalValueDataModel;
import Mapper.MCMapperImpl;
import Mapper.Mapper;

public class mc_render extends render{

	private static NameValuePair fundamentalValuesTag = new NameValuePair("class", "FR gD_12"); 
	private static NameValuePair currentPriceTag      = new NameValuePair("id", "Bse_Prc_tick");
	private static NameValuePair companyNameTag       = new NameValuePair("class", "b_42");

	static Mapper map = new MCMapperImpl();

	public GeneralFundamentalValueDataModel render(String url) {
		try{
			final ArrayList<String> holder= new ArrayList<String>();
			GeneralFundamentalValueDataModel fundamentals = new GeneralFundamentalValueDataModel();

			Document doc = curlWebPage(url);
			// TODO Auto-generated method stub
			Element body = doc.body();
			Elements elements = body.getElementsByAttributeValue(fundamentalValuesTag.getName(), fundamentalValuesTag.getValue());
			for(Element element : elements) {

				holder.add(element.toString().substring(24, element.toString().length()-7));

			}
			Elements StockPrice = body.getElementsByAttributeValue(currentPriceTag.getName(), currentPriceTag.getValue());
			holder.add(StockPrice.toString().substring(32, StockPrice.toString().length()-16));
			map.map(fundamentals, holder);
			Elements companyName = body.getElementsByAttributeValue(companyNameTag.getName(), companyNameTag.getValue());
			fundamentals.setCompany(companyName.toString().substring(17, companyName.toString().length()-5));
			return fundamentals;
		}
		catch (Exception e) {
			// Nothing to do
		}
		return null;
	}
}
