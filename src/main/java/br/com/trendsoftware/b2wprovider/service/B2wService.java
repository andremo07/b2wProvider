package br.com.trendsoftware.b2wprovider.service;

import org.apache.log4j.Logger;

import br.com.trendsoftware.b2wprovider.http.client.B2wClient;

public class B2wService {
	
	protected B2wClient b2w;
	
	private Logger logger;
	
	public B2wService(){
		b2w = new B2wClient();
	}
	
	public B2wClient getB2w() {
		return b2w;
	}

	public void setB2w(B2wClient b2w) {
		this.b2w = b2w;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
}
