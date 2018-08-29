package br.com.trendsoftware.b2wprovider.dataprovider;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import br.com.trendsoftware.b2wprovider.dto.SkyHubUserCredencials;

public abstract class B2wProvider
{
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@PostConstruct
	public void init(){
		setLogger(logger);
	}
	
	private Gson parser;
	
	public B2wProvider(){
		parser = new Gson();
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Gson getParser() {
		return parser;
	}

	public void setParser(Gson parser) {
		this.parser = parser;
	}
	
	public Map<String,String> createBw2HeaderRequest (SkyHubUserCredencials userCredencials){
		Map<String,String> headersMap = new HashMap<String,String>();
		headersMap.put("X-User-Email", userCredencials.getUserEmail());
		headersMap.put("x-Api-Key", userCredencials.getApiKey());
		headersMap.put("x-accountmanager-key", userCredencials.getAccountManagerKey());
		return headersMap;
	}
}
