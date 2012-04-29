package br.batcave;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class HelloWorldWS {
	
	@WebMethod
	public String sayHelloTo(String name){
		return "hello " + name;
	}
	
	public static void main(String[] args) {
		HelloWorldWS service = new HelloWorldWS();
		Endpoint endpoint = Endpoint.create(service);
		endpoint.publish("http://localhost:8080/helloWorld");
	}
}
