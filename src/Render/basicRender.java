/**
 * 
 */
package Render;

import DataModel.GeneralFundamentalValueDataModel;


/**
 * @author gidakash
 * Will render data from either web or from DB.
 */
public interface basicRender {
 
	public GeneralFundamentalValueDataModel render(String url);
}
