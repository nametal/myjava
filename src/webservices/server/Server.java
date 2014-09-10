package webservices.server;

import javax.xml.ws.Endpoint;

public class Server {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2487/Helow", new HelloWeb());
		System.out.println("Helow is ready...");
	}
}
