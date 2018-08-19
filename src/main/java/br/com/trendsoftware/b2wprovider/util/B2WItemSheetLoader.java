package br.com.trendsoftware.b2wprovider.util;

import java.util.ArrayList;
import java.util.List;

import br.com.trendsoftware.b2wprovider.dto.SkyHubCategory;
import br.com.trendsoftware.b2wprovider.dto.SkyHubItem;

public class B2WItemSheetLoader {

	public static List<SkyHubItem> load(List<List<String>> values) throws Exception
	{
		List<SkyHubItem> itens = new ArrayList<SkyHubItem>();
		
		for(int index=2; index<values.size();index++){
			List<String> rowValues = values.get(index);
			SkyHubItem item = new SkyHubItem();
			item.setStatus("enabled");
			item.setSku(rowValues.get(0));
			item.setEan(rowValues.get(1));
			item.setName(rowValues.get(2));
			item.setDescription(rowValues.get(3));
			item.setBrand(rowValues.get(4));
			
			List<SkyHubCategory> list_cat = new ArrayList<SkyHubCategory>();
			SkyHubCategory cat = new SkyHubCategory();
			cat.setCode(rowValues.get(6));
			cat.setName(rowValues.get(7));
			list_cat.add(cat);
			
			item.setCategories(list_cat);
			
			item.setWeight(new Double(rowValues.get(12)));
			item.setHeight(new Double(rowValues.get(13)));
			item.setLength(new Double(rowValues.get(14)));
			item.setWidth(new Double(rowValues.get(15)));
			item.setPrice(new Double(rowValues.get(17)));
			item.setPromotionalPrice(new Double(rowValues.get(18)));
			item.setQty(new Double(rowValues.get(19)).longValue());
			List<String> images = new ArrayList<String>();
			for(int indImg=20; indImg<rowValues.size();indImg++)
				if(rowValues.get(indImg)!=null && !rowValues.get(indImg).equals(""))
					images.add(rowValues.get(indImg));
				else
					break;
			item.setImages(images);
			itens.add(item);
		}
		return itens;
	}


}
