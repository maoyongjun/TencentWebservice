package org.foxconn.config;


import javax.annotation.Resource;

import org.apache.cxf.Bus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxrs.spring.JAXRSServerFactoryBeanDefinitionParser.SpringJAXRSServerFactoryBean;
import org.foxconn.dao.WebServiceDao;
import org.foxconn.service.RestService;
import org.foxconn.service.impl.RestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:myz
 */
@Configuration
public class CxfConfig {
	@Autowired
	private Bus bus;
	@Resource
	RestService service;
	@Bean
	public SpringJAXRSServerFactoryBean createRs() {
		SpringJAXRSServerFactoryBean restFactory = new SpringJAXRSServerFactoryBean();
		restFactory.setServiceClass(RestService.class);
		restFactory.setServiceBean(service);
		restFactory.setAddress("/tencent");
		restFactory.setBus(bus);
		
		restFactory.getInInterceptors().add(new LoggingInInterceptor());
		
		restFactory.create();
		return restFactory;
	}

	
}
