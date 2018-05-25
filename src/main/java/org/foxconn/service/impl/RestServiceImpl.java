package org.foxconn.service.impl;


import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.foxconn.dao.WebServiceDao;
import org.foxconn.entity.TestResult;
import org.foxconn.entity.UpdateResultMessage;
import org.foxconn.service.RestService;
import org.springframework.stereotype.Service;
@Service
public class RestServiceImpl implements RestService{
	@Resource
	private WebServiceDao dao;
	
	public void setDao(WebServiceDao dao){
		this.dao = dao;
	}
	@GET
	@Path("/ssnStatus/{plant}/{ssn}")
	@Produces({ MediaType.APPLICATION_JSON })
	public UpdateResultMessage getSSN(@PathParam("plant")String plant,@PathParam("ssn")String ssn) {
		StringBuilder s = new StringBuilder();
		s.append(plant+",").append(ssn);
		System.out.println(plant);
		System.out.println(ssn);
		UpdateResultMessage msg = new UpdateResultMessage();
		msg.setStatus(ssn);
		dao.getSSNStatus();
		return msg;
	}
	@POST
	@Path("/ssnStatus")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public UpdateResultMessage updateSSN(TestResult result){
		UpdateResultMessage msg = new UpdateResultMessage();
		msg.setStatus("OK:"+result.getResult());
		return msg;
		
	}
	

}
