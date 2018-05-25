package org.foxconn.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
* @author:myz
* @version 1.0 
*/
public class CxfClient {
//	public static void main(String[] args) {
//		cl1();
//	}

	/**
	 */
	public static void cl1() {
		try {
			String address = "http://localhost:8080/services/CommonService?wsdl";
			JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
			jaxWsProxyFactoryBean.setAddress(address);
			String userName = "Leftso";
//			String result = cs.sayHello(userName);
//			System.out.println("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 */
	public static void cl2() {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://localhost:8080/services/CommonService?wsdl");
		// client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
		// PASS_WORD));
		Object[] objects = new Object[0];
		try {
			objects = client.invoke("sayHello", "Leftso");
			System.out.println("result:" + objects[0]);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
	}
}
