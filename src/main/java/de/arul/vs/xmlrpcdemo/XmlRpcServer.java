package de.arul.vs.xmlrpcdemo;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.server.XmlRpcStreamServer;
import org.apache.xmlrpc.webserver.WebServer;

import de.arul.vs.util.logging.LogLevel;
import de.arul.vs.util.logging.Logging;

public class XmlRpcServer {
    private static final int port = 1234;

	static
	{
		Logging.setLoggingDefaults(LogLevel.INFO, "[%-5p; %c{1}::%M] %m%n");
	}
    
    public static void main(String[] args) throws Exception {
    	// Obtain an instance of a logger for this class
    	// Logger log = LoggerFactory.getLogger(XmlRpcServer.class);
    	
        WebServer webServer = new WebServer(port);
        XmlRpcStreamServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();
		
        phm.addHandler("Calculator", CalculatorDemo.class);
		
        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig = 
			(XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        webServer.start();
    }
}

