package br.com.trendsoftware.b2wprovider.http.client;


import br.com.trendsoftware.restProvider.http.client.RestClient;

public class B2wClient extends RestClient {

	public static final String API_URL = "https://api.skyhub.com.br";
	
	@Override
	public String getApiUrl() {	
		return API_URL;
	}
	
}
