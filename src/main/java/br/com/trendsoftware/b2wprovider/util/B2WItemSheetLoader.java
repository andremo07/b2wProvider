package br.com.trendsoftware.b2wprovider.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.trendsoftware.b2wprovider.dto.SkyHubCategory;
import br.com.trendsoftware.b2wprovider.dto.SkyHubItem;
import br.com.trendsoftware.b2wprovider.dto.SkyHubVariation;
import br.com.trendsoftware.b2wprovider.dto.Specification;

public class B2WItemSheetLoader {

	public static List<SkyHubItem> load(List<List<String>> values) throws Exception
	{
		List<SkyHubItem> itens = new ArrayList<SkyHubItem>();

		for(int index=2; index<values.size();index++)
		{	
			List<String> rowValues = values.get(index);

			if(rowValues.get(0).equals(rowValues.get(10)))
			{
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
				for(int indImg=20; indImg<26;indImg++)
					if(rowValues.get(indImg)!=null && !rowValues.get(indImg).equals(""))
						images.add(rowValues.get(indImg));
					else
						break;
				item.setImages(images);
				
				if(rowValues.size()==27)
				{
					List<Specification> fatherSpecifications = new ArrayList<Specification>();
					Specification fatherSpecification1 = new Specification();
					Specification fatherSpecification2 = new Specification();
					fatherSpecification1.setKey("cor");
					fatherSpecification1.setValue(rowValues.get(26));
					fatherSpecification2.setKey("Tamanho");
					fatherSpecification2.setValue("N/A");
					fatherSpecifications.add(fatherSpecification1);		
					fatherSpecifications.add(fatherSpecification2);		
					item.setSpecifications(fatherSpecifications);
				}

				List<List<String>> variationsRows = values.stream().filter(columns -> columns.get(10).equals(rowValues.get(0))).collect(Collectors.toList());

				if(variationsRows.size()>1)
				{
					List<SkyHubVariation> variations = new ArrayList<SkyHubVariation>();
					variationsRows.stream().forEach(variationRow -> {
						SkyHubVariation variation = new SkyHubVariation();
						variation.setSku(variationRow.get(0));
						variation.setEan(variationRow.get(1));
						variation.setQty(new Double(variationRow.get(19)).longValue());

						List<Specification> specifications = new ArrayList<Specification>();
						Specification specification1 = new Specification();
						Specification specification2 = new Specification();
						specification1.setKey("cor");
						specification1.setValue(variationRow.get(26));
						//specification2.setKey("Tamanho");
						//specification2.setValue("N/A");
						specifications.add(specification1);		
						//specifications.add(specification2);		
						variation.setSpecifications(specifications);

						List<String> variationImages = new ArrayList<String>();
						for(int indImg=20; indImg<26;indImg++)
							if(variationRow.get(indImg)!=null && !variationRow.get(indImg).equals(""))
								variationImages.add(variationRow.get(indImg));
							else
								break;
						variation.setImages(variationImages);

						variations.add(variation);
					});
					item.setVariations(variations);
					
					List<String> variationAttributes = new ArrayList<String>();
					variationAttributes.add("cor");
					//variationAttributes.add("Tamanho");
					item.setVariationAttributes(variationAttributes);
				}

				itens.add(item);
			}
		}
		return itens;
	}


}
