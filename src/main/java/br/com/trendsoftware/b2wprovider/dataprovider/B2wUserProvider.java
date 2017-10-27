package br.com.trendsoftware.b2wprovider.dataprovider;

import java.io.IOException;

import org.apache.commons.httpclient.HttpStatus;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.Response;

import br.com.trendsoftware.b2wprovider.dto.Error;
import br.com.trendsoftware.b2wprovider.dto.SkyHubUserCredencials;
import br.com.trendsoftware.b2wprovider.response.B2wResponse;
import br.com.trendsoftware.b2wprovider.service.UserService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class B2wUserProvider extends B2wProvider{

	private UserService userService;
	
	public B2wUserProvider() {
		
		initializeService();
		
	}
	
	@Override
	protected void initializeService() {
	
		userService = new UserService();
	}

	public B2wResponse getUserInfo(SkyHubUserCredencials userCredencials) throws ProviderException{

		try {

			getLogger().trace("searching user info");

			long before = System.currentTimeMillis();
			
			FluentCaseInsensitiveStringsMap headers = createBw2HeaderRequest(userCredencials);

			Response response = userService.getUserInfo(headers);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return B2wResponse.getPrototype(response, after - before);
		}
		catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		} 
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}

	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
