package br.com.trendsoftware.b2wprovider.dto;

public class SkyHubUserCredencials {
	
    private String userEmail;
    private String apiKey;
    private String accountManagerKey;
    
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getAccountManagerKey() {
		return accountManagerKey;
	}
	public void setAccountManagerKey(String accountManagerKey) {
		this.accountManagerKey = accountManagerKey;
	}
	
}
