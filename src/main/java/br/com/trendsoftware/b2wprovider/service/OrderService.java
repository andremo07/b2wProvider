package br.com.trendsoftware.b2wprovider.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.dto.OrderStatus;
import br.com.trendsoftware.b2wprovider.http.client.B2wClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class OrderService extends B2wService{
	
	public Response getOrderById(Map<String,String> headers,String orderId) throws ServiceException{

		try {
			Response response = B2wClient.get(B2wClient.API_URL,"/orders/"+orderId,null,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getOrders(Map<String,String> headers,Integer page, Integer maxItens, String marketPlace, String status) throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			if(page!=null)
				params.put("page", Collections.singletonList((page.toString())));
			if(maxItens!=null)
				params.put("per_page", Collections.singletonList((maxItens.toString())));
			if(marketPlace!=null)
				params.put("filters[sale_system]", Collections.singletonList((marketPlace)));
			if(status!=null)
				params.put("filters[statuses][]", Collections.singletonList((status)));
			Response response = B2wClient.get(B2wClient.API_URL,"/orders/",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getQueueOrder(Map<String,String> headers) throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			Response response = B2wClient.get(B2wClient.API_URL,"/queues/orders",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		} 
	}
	
	public Response process(Map<String,String> headers, String code) throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			Response response = B2wClient.delete(B2wClient.API_URL,"/queues/orders/"+code,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response approve(Map<String,String> headers, String code) throws ServiceException{

		try {
			Response response = B2wClient.post(B2wClient.API_URL,"/orders/"+code+"/approval", null,headers,"{\"status\": \""+OrderStatus.APPROVED.getName()+"\"}");
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response invoice(Map<String,String> headers, String code, String nfNumber) throws ServiceException{

		try {
			Response response = B2wClient.post(B2wClient.API_URL,"/orders/"+code+"/invoice", null, headers, "{\"status\": \""+OrderStatus.APPROVED.getName()+"\", \"invoice\":{\"key\":\"" + nfNumber + "\"}}");
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
	}
	
	
	public Response cancel(Map<String,String> headers, String code) throws ServiceException{

		try {
			Response response = B2wClient.post(B2wClient.API_URL,"/orders/"+code+"/cancel", null, headers, null);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response complete(Map<String,String> headers, String code) throws ServiceException{

		try {
			Response response = B2wClient.post(B2wClient.API_URL,"/orders/"+code+"/delivery", null, headers, "{\"status\": \""+OrderStatus.COMPLETE.getName()+"\"}");
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response create(Map<String,String> headers, String json) throws ServiceException{

		try {
			Response response = B2wClient.post(B2wClient.API_URL,"/orders/",null,headers,json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER_MESSAGES, e.getMessage()), e);
		}
		
	}
	
}
