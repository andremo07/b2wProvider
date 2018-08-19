package br.com.trendsoftware.b2wprovider.dataprovider;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;

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
	
	public FluentCaseInsensitiveStringsMap createBw2HeaderRequest (SkyHubUserCredencials userCredencials){
		FluentCaseInsensitiveStringsMap headersMap = new FluentCaseInsensitiveStringsMap();
		headersMap.add("X-User-Email", userCredencials.getUserEmail());
		headersMap.add("x-Api-Key", userCredencials.getApiKey());
		headersMap.add("x-accountmanager-key", userCredencials.getAccountManagerKey());
		headersMap.add("Content-Type", "application/json; charset=utf-8");
		headersMap.add("Accept", "application/json;");
		return headersMap;
	}
	
	protected abstract void initializeService();
	
}
