package webservices.client;

public class Client {
	public static void main(String[] args) {
		HelloWebService service = new HelloWebService();
		HelloWeb web = service.getHelloWebPort();
		String response = web.greet("Harun");
		System.out.println("This is response from web service: " + response);
	}
}
