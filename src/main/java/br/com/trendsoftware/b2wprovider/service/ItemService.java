package br.com.trendsoftware.b2wprovider.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.http.client.B2wClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class ItemService extends B2wService{
	
	public Response getItemById(Map<String,String> headers,String itemId)throws ServiceException{

		try {
			 Map<String, List<String>> params = new  HashMap<String, List<String>>();
			Response response = B2wClient.get(B2wClient.API_URL,"/items/"+itemId,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITEM, e.getMessage()), e);
		}

	}

	public Response getItensByStatus(Map<String,String> headers,String itemStatus)throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			params.put("status",Collections.singletonList(itemStatus));
			Response response = B2wClient.get(B2wClient.API_URL,"/products?",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}
	}
	
	public Response getItens(Map<String,String> headers)throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			Response response = B2wClient.get(B2wClient.API_URL,"/products?",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}
	}
	
	public Response getItens(Map<String,String> headers, String nextItensEndpoint)throws ServiceException{
		try {
			Response response = B2wClient.get(nextItensEndpoint, headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_ITENS, e.getMessage()), e);
		}
	}
	
	public Response add(Map<String,String> headers,String json)throws ServiceException{

		try {
			Response response = B2wClient.post(B2wClient.API_URL,"/products",null,headers,json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_ADD_ITEM, e.getMessage()), e);
		}
		
	} 

}
