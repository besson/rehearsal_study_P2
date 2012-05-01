package br.batcave.starter;

import br.batcave.HelloWorldWSService;

public class ClientStarter {
	
	public static void main(String[] args) {
		HelloWorldWSService service = new HelloWorldWSService();
		System.out.println(service.getHelloWorldWSPort().sayHelloTo("John"));
	}

}
