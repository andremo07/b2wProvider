package br.com.trendsoftware.b2wprovider.dataprovider;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.asynchttpclient.Response;

import br.com.trendsoftware.b2wprovider.dto.Error;
import br.com.trendsoftware.b2wprovider.dto.Marketplaces;
import br.com.trendsoftware.b2wprovider.dto.OrderStatus;
import br.com.trendsoftware.b2wprovider.dto.SkyHubCreateOrder;
import br.com.trendsoftware.b2wprovider.dto.SkyHubUserCredencials;
import br.com.trendsoftware.b2wprovider.response.B2wResponse;
import br.com.trendsoftware.b2wprovider.service.OrderService;
import br.com.trendsoftware.restProvider.exception.MessageException;
import br.com.trendsoftware.restProvider.exception.ProviderException;
import br.com.trendsoftware.restProvider.exception.ServiceException;
import br.com.trendsoftware.restProvider.response.RestResponse;
import br.com.trendsoftware.restProvider.util.ExceptionUtil;

public class B2wOrderProvider extends B2wProvider{
	
	public B2wResponse searchOrderById(SkyHubUserCredencials userCredencials,String orderId) throws ProviderException {

		try {

			getLogger().trace("searching order by id="+orderId);
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();

			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.getOrderById(headers,orderId);
			
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

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	
	public B2wResponse listQueueOrder(SkyHubUserCredencials userCredencials) throws ProviderException {

		try {

			getLogger().trace("searching orders");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.getQueueOrder(headers);
			
			if(response.getStatusCode()!=HttpStatus.SC_OK){
				if(response.getResponseBody()!=null && !response.getResponseBody().isEmpty()){
					Error error = getParser().fromJson(response.getResponseBody(), Error.class);
					throw new ProviderException(error.getError().toUpperCase(),error.getStatus().toString(),error.getMessage());
				}
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return B2wResponse.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public B2wResponse processQueueOrder(SkyHubUserCredencials userCredencials, String code) throws ProviderException {

		try {

			getLogger().trace("searching orders");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.process(headers,code);
			
			if(response.getStatusCode()!=HttpStatus.SC_NO_CONTENT){
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

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public B2wResponse createTestOrder(SkyHubUserCredencials userCredencials, SkyHubCreateOrder order) throws ProviderException {

		try {

			getLogger().trace("creating test order");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.create(headers,"{\"order\":"+getParser().toJson(order)+"}");
			
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

			return B2wResponse.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	
	public B2wResponse approveOrder(SkyHubUserCredencials userCredencials, String code) throws ProviderException {

		try {

			getLogger().trace("approving order");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.approve(headers,code);
			
			if(response.getStatusCode()!=HttpStatus.SC_CREATED){
				throw new ProviderException(MessageException.ERROR_APPROVE_ORDER);
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return B2wResponse.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public B2wResponse invoiceOrder(SkyHubUserCredencials userCredencials, String code, String nfNumber) throws ProviderException {

		try {

			getLogger().trace("approving order");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.invoice(headers,code,nfNumber);
			
			if(response.getStatusCode()!=HttpStatus.SC_CREATED){
				throw new ProviderException(MessageException.ERROR_INVOICE_ORDER);
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return B2wResponse.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public B2wResponse completeOrder(SkyHubUserCredencials userCredencials, String code) throws ProviderException {

		try {

			getLogger().trace("cancelling order");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.complete(headers,code);
			
			if(response.getStatusCode()!=HttpStatus.SC_CREATED){
				throw new ProviderException(MessageException.ERROR_CANCEL_ORDER);
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return B2wResponse.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public B2wResponse cancelOrder(SkyHubUserCredencials userCredencials, String code, String nfNumber) throws ProviderException {

		try {

			getLogger().trace("cancelling order");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			Response response = orderService.invoice(headers,code,nfNumber);
			
			if(response.getStatusCode()!=HttpStatus.SC_CREATED){
				throw new ProviderException(MessageException.ERROR_CANCEL_ORDER);
			}

			long after = System.currentTimeMillis();

			getLogger().trace(response.toString());

			return B2wResponse.getPrototype(response, after - before);

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
	}
	
	public RestResponse listOrders(SkyHubUserCredencials userCredencials, Integer page, Integer maxItens, Marketplaces marketPlace, OrderStatus status) throws ProviderException {
		
		try {

			getLogger().trace("searching orders");
			
			OrderService orderService = new OrderService();

			long before = System.currentTimeMillis();
			
			Map<String,String> headers = createBw2HeaderRequest(userCredencials);
			
			String nmMarketplace = null;
			String nmStatus = null;
			
			if(marketPlace!=null)
				nmMarketplace = marketPlace.getName();
			
			if(status!=null)
				nmStatus = status.getName();
			
			Response response = orderService.getOrders(headers,page,maxItens,nmMarketplace,nmStatus);
			
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

		} catch (ServiceException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.GENERAL_ERROR);
		}
		catch (IOException e) {
			getLogger().error(ExceptionUtil.getStackTrace(e));
			throw new ProviderException(MessageException.BODY_RESPONSE_ERROR);
		}	
		
	}
	
}
