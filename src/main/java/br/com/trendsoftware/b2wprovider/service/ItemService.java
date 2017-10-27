package br.com.trendsoftware.b2wprovider.service;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class ItemService extends B2wService{
	
	public Response getItemById(FluentCaseInsensitiveStringsMap headers,String itemId)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			Response response = b2w.get("/items/"+itemId,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITEM, e.getMessage()), e);
		}

	}

	public Response getItens(FluentCaseInsensitiveStringsMap headers,String sellerId, String itemStatus, String offset)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			params.add("offset", offset);
			params.add("status", itemStatus);
			Response response = b2w.get("/users/"+sellerId+"/items/search",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}

	}
	
	public Response add(FluentCaseInsensitiveStringsMap headers,String json)throws ServiceException{

		try {
			Response response = b2w.post("/products",null,headers,json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_ADD_ITEM, e.getMessage()), e);
		}
		
	} 

}
