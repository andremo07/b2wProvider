package br.com.trendsoftware.b2wprovider.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.http.client.B2wClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class ShippingService extends B2wService{
		
	public Response getShippingById(Map<String,String> headers, String shippingId)throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			Response response = B2wClient.get(B2wClient.API_URL,"/shipments/"+shippingId,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}
	

}
