package br.com.trendsoftware.b2wprovider.service;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class ShippingService extends B2wService{
		
	public Response getShippingById(FluentCaseInsensitiveStringsMap headers, String shippingId)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			Response response = b2w.get("/shipments/"+shippingId,params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_SHIPPING_INFO, e.getMessage()), e);
		}
		
	}
	

}
