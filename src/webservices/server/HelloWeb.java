package webservices.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWeb {
	@WebMethod
	public String greet(String name) {
		return "Ola! " + name + "!";
	}
}
