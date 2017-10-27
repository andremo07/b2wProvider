package br.com.trendsoftware.b2wprovider.service;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class UserService extends B2wService{
			
	public Response getUserInfo(FluentCaseInsensitiveStringsMap headers)throws ServiceException{

		try {
			FluentStringsMap params = new FluentStringsMap();
			Response response = b2w.get("/users/me",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()), e);
		}
		
	}
	

}
