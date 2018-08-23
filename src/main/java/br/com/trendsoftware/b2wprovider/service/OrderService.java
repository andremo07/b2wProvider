package br.com.trendsoftware.b2wprovider.service;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.b2wprovider.dto.OrderStatus;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class OrderService extends B2wService{
	
	public Response getOrderById(FluentCaseInsensitiveStringsMap headers,String orderId) throws ServiceException{

		try {
			Response response = b2w.get("/orders/"+orderId,null,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getOrders(FluentCaseInsensitiveStringsMap headers,Integer page, Integer maxItens, String marketPlace, String status) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			if(page!=null)
				params.add("page", page.toString());
			if(maxItens!=null)
				params.add("per_page", maxItens.toString());
			if(marketPlace!=null)
				params.add("filters[sale_system]", marketPlace);
			if(status!=null)
				params.add("filters[statuses][]", status);
			Response response = b2w.get("/orders/",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response getQueueOrder(FluentCaseInsensitiveStringsMap headers) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			Response response = b2w.get("/queues/orders",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response process(FluentCaseInsensitiveStringsMap headers, String code) throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			Response response = b2w.delete("/queues/orders/"+code,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response approve(FluentCaseInsensitiveStringsMap headers, String code) throws ServiceException{

		try {
			Response response = b2w.post("/orders/"+code+"/approval", null,headers,"{\"status\": \""+OrderStatus.APPROVED.getName()+"\"}");
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response invoice(FluentCaseInsensitiveStringsMap headers, String code, String nfNumber) throws ServiceException{

		try {
			Response response = b2w.post("/orders/"+code+"/invoice", null, headers, "{\"status\": \""+OrderStatus.APPROVED.getName()+"\", \"invoice\":{\"key\":\"" + nfNumber + "\"}}");
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
	}
	
	
	public Response cancel(FluentCaseInsensitiveStringsMap headers, String code) throws ServiceException{

		try {
			Response response = b2w.post("/orders/"+code+"/cancel", null, headers, null);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response complete(FluentCaseInsensitiveStringsMap headers, String code) throws ServiceException{

		try {
			Response response = b2w.post("/orders/"+code+"/delivery", null, headers, "{\"status\": \""+OrderStatus.COMPLETE.getName()+"\"}");
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER, e.getMessage()), e);
		}
		
	}
	
	public Response create(FluentCaseInsensitiveStringsMap headers, String json) throws ServiceException{

		try {
			Response response = b2w.post("/orders/",null,headers,json);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_ORDER_MESSAGES, e.getMessage()), e);
		}
		
	}
	
}
