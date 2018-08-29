package br.com.trendsoftware.b2wprovider.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.http.client.B2wClient;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.RestClientException;
import br.com.trendsoftware.restProvider.exception.ServiceException;

public class UserService extends B2wService{
			
	public Response getUserInfo(Map<String,String> headers)throws ServiceException{

		try {
			Map<String, List<String>> params = new  HashMap<String, List<String>>();
			Response response = B2wClient.get(B2wClient.API_URL,"/users/me",params,headers);
			return response;	
		} catch (RestClientException e) {	
			throw new ServiceException(String.format("%s:%s", MessageException.ERROR_QUERY_USER_INFO, e.getMessage()), e);
		}
		
	}
}
