package com.cysomel.backend.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class blueTooth extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		 
		//restConfiguration().host("localhost").port(8080);
		rest("/test")
		 .get()
			.produces("text/plain")
			.route()
			.routeId("WsTester")
			.process(new Processor() {
				public void process(Exchange exch) throws Exception {
				exch.getIn().setHeader("charset","UTF-8");
				exch.getIn().setBody("Hello World ! ;)");
				}
			});   
	}
}