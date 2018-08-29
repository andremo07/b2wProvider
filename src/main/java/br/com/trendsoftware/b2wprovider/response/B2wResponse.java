package br.com.trendsoftware.b2wprovider.response;

import java.io.IOException;

import org.asynchttpclient.Response;

import br.com.trendsoftware.restProvider.response.RestResponse;

public class B2wResponse extends RestResponse
{	
	public boolean isResponseOK() {
		return getStatusCode().equals(200);
	}
	
	public static B2wResponse getPrototype(Response response, Long timeLapsed) throws IOException
	{
		B2wResponse mlReponse = new B2wResponse();
		
		mlReponse.setBody(response.getResponseBody());
		mlReponse.setContentType(response.getContentType());
		mlReponse.setStatusCode(response.getStatusCode());
		mlReponse.setStatusMessage(response.getStatusText());
		mlReponse.setTimeLapsed(timeLapsed);
		
		return mlReponse;
	}
	
}
