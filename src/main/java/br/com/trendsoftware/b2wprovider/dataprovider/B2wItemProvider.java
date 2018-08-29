package br.com.trendsoftware.b2wprovider.dataprovider;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.dto.Error;
import br.com.trendsoftware.b2wprovider.dto.SkyHubItem;
import br.com.trendsoftware.b2wprovider.dto.SkyHubUserCredencials;
import br.com.trendsoftware.b2wprovider.response.B2wResponse;
import br.com.trendsoftware.b2wprovider.service.ItemService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class B2wItemProvider extends B2wProvider{

	public B2wResponse searchItemById(SkyHubUserCredencials userCredencials, String itemId) throws ProviderException{

		try {

			ItemService itemService = new ItemService();
			
			getLogger().trace("searching item " + itemId);

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);

			Response response = itemService.getItemById(headers,itemId);

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
	
	
	public B2wResponse addItem(SkyHubUserCredencials userCredencials,SkyHubItem item) throws ProviderException{

		try {

			getLogger().trace("adding item");
			
			ItemService itemService = new ItemService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);

			Response response = itemService.add(headers,"{\"product\":"+getParser().toJson(item)+"}");

			if(response.getStatusCode()!=HttpStatus.SC_CREATED){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
				else
					throw new ProviderException(response.getStatusCode()+"-"+response.getStatusText());
			}
			
			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			B2wResponse mlResponse = B2wResponse.getPrototype(response, after - before);
			
			mlResponse.setBody(getParser().toJson(item));
			
			return mlResponse;
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
			
}
