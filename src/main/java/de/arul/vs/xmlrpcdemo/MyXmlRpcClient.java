package de.arul.vs.xmlrpcdemo;

import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class MyXmlRpcClient {

	public static void main(String[] args) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://127.0.0.1:1234/xmlrpc"));
		config.setEnabledForExtensions(true);
		config.setConnectionTimeout(60 * 1000);
		config.setReplyTimeout(60 * 1000);

		XmlRpcClient client = new XmlRpcClient();


		client.setConfig(config);

		Object[] params = new Object[] { new Integer(2), new Integer(3) };
		Integer result = (Integer) client.execute("Calculator.add", params);
		System.out.println("2 + 3 = " + result);

	}
}
