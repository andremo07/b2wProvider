package br.com.trendsoftware.b2wprovider.dataprovider;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.dto.Error;
import br.com.trendsoftware.b2wprovider.dto.SkyHubUserCredencials;
import br.com.trendsoftware.b2wprovider.response.B2wResponse;
import br.com.trendsoftware.b2wprovider.service.ShippingService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class B2wShippingProvider extends B2wProvider{
	
	public B2wResponse searchShippingById(SkyHubUserCredencials userCredencials, String shippingId) throws ProviderException{

		try {

			getLogger().trace("searching user info");
			
			ShippingService shippingService = new ShippingService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);

			Response response = shippingService.getShippingById(headers,shippingId);

			if(response.getStatusCode()!=HttpStatus.SC_OK){
				Error error = getParser().fromJson(response.getResponseBody(), Error.class);
				throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
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
}
