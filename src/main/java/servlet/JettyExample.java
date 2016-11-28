package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettyExample {
  
  /**
   * Jetty
   * Jetty has been designed to be lightweight and easy to use.
   * You can even create and run servers purely in Java code, with no configuration.
   * */
  
  public static void main(String args[]) throws Exception {
    final Server jettyServer = new Server(8080);
    jettyServer.setHandler(new EchoHandler());
    jettyServer.start();
    System.out.println(Server.getVersion());
    jettyServer.join();
  }
}

class EchoHandler extends AbstractHandler {
  
  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("text/plain");
    response.setStatus(HttpServletResponse.SC_OK);
    baseRequest.setHandled(true);
    
    final ServletInputStream requestInputStream = request.getInputStream();
    final ServletOutputStream responseOutputStream = response.getOutputStream();
    
    IOUtils.copy(requestInputStream, responseOutputStream);
  }
}

/**
 * You can configure Jetty to run in several lines of code.
 * 
 * This code configures a server to respond to any client with the same body of the request.
 * The HTTP POST and PUT methods have bodies, so requests with these methods will respond appropriately.
 * 
 * */
