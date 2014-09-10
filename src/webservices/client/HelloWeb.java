
package webservices.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWeb", targetNamespace = "http://server.webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWeb {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "greet", targetNamespace = "http://server.webservices/", className = "webservices.client.Greet")
    @ResponseWrapper(localName = "greetResponse", targetNamespace = "http://server.webservices/", className = "webservices.client.GreetResponse")
    @Action(input = "http://server.webservices/HelloWeb/greetRequest", output = "http://server.webservices/HelloWeb/greetResponse")
    public String greet(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
