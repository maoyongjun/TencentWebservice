package org.foxconn.service.impl;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.foxconn.dao.WebServiceDao;
import org.foxconn.entity.Msg;
import org.foxconn.entity.Result;
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
	@Path("/efoxsfcSSNSTATUS/{strPlantCode}/{strSSN}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Msg getSSN(@PathParam("strPlantCode")String plant,@PathParam("strSSN")String ssn) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("plant", plant);
		map.put("ssn", ssn);
		map.put("retflag", "");
		map.put("retmsg", "");
		dao.getSSNStatus( map);
		Msg msg =new Msg();
		msg.setRetflag(map.get("retflag"));
		msg.setRetmsg(map.get("retmsg"));
		return msg;
	}
	@POST
	@Path("/efoxsfcSSNSTATUS")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Msg updateSSN(Result result){
		System.out.println( result.toString());
		Map<String,String> map = new HashMap<String,String>();
		map.put("strPlantCode",result.getStrPlantCode());
		map.put("strSSN",result.getStrSSN());
		map.put("strFixtureID",result.getStrFixtureID());
		map.put("strTestResult",result.getStrTestResult());
		map.put("strErrorCode",result.getStrErrorCode());
		map.put("strFailDetailReason",result.getStrFailDetailReason());
		map.put("strTestDatatime",result.getStrTestDatatime());
		map.put("strEMPID",result.getStrEMPID());
		map.put("strDIAG",result.getStrDIAG());
		map.put("strCurStation",result.getStrCurStation());
		map.put("strLineName",result.getStrLineName());
		map.put("strField1",result.getStrField1());
		map.put("strField2",result.getStrField2());
		map.put("strField3",result.getStrField3());
		map.put("strActionCode",result.getStrActionCode());
		map.put("strActionDesc",result.getStrActionDesc());
		map.put("strReplacePN",result.getStrReplacePN());
		map.put("strFailCSN",result.getStrFailCSN());
		map.put("strNewCSN",result.getStrNewCSN());
		map.put("strField4",result.getStrField4());
		map.put("strField5",result.getStrField5());
		map.put("strField6",result.getStrField6());
		map.put("strField7",result.getStrField7());
		map.put("strField8",result.getStrField8());
		map.put("strField9",result.getStrField9());
		map.put("strAtoTestLogname",result.getStrAtoTestLogname());
		map.put("strAtoTestParam",result.getStrAtoTestParam());
		map.put("strATOTestApplicationVersion",result.getStrATOTestApplicationVersion());
		map.put("strClientIp",result.getStrClientIp  ());
		map.put("strWebUrl",result.getStrWebUrl ());
		map.put("retflag", "");
		map.put("retmsg", "");
		Msg msg=new Msg();
		msg.setRetflag(map.get("retflag"));
		msg.setRetmsg(map.get("retmsg"));
		return msg;
		
	}
	

}
