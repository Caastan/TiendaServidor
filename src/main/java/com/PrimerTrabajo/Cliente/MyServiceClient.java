package com.PrimerTrabajo.Cliente;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;

	@WebServiceClient(name = "MyService", targetNamespace = "http://example.com/myservice", wsdlLocation = "http://example.com/myservice?wsdl")
	public class MyServiceClient extends Service {
	
		private static final URL WSDL_LOCATION;
		private static final QName SERVICE_NAME = new QName("http://example.com/myservice", "MyService");
		
		static {
			URL url = null;
			try {
				url = new URL("http://example.com/myservice?wsdl");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			WSDL_LOCATION = url;
	    }
	
		public MyServiceClient() {
			super(WSDL_LOCATION, SERVICE_NAME);
	    }	
	
		public MyServiceClient(URL wsdlLocation, QName serviceName) {
			super(wsdlLocation, serviceName);
	    }	
	
		@WebEndpoint(name = "MyServicePort")
		public MyServicePortType getMyServicePort() {
			return super.getPort(new QName("http://example.com/myservice", "MyServicePort"), MyServicePortType.class);
	    }	
	}
