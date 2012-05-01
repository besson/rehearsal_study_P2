package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import eu.choreos.model.User;

@WebService
public class GreetingAWS {

	@WebMethod
	public String sayHi(@WebParam(name="input") String input){
		return "hi " + input + ",";
	}
	
	@WebMethod
	public User getWho(String id){
		User user = new User(id, "Felipe", "25", "matao street");
		
		return user;
	}
	
}
