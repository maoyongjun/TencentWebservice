package org.foxconn.service;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.foxconn.dao.WebServiceDao;
import org.foxconn.entity.Msg;
import org.foxconn.entity.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/efoxsfcSSNSTATUS")
public class RestService{
	Logger logger = Logger.getLogger(RestService.class);
	@Resource
	private WebServiceDao dao;
	
	@RequestMapping(value="/{strPlantCode}/{strSSN}", method=RequestMethod.GET,produces = "application/json; charset=UTF-8") 
	@ResponseBody
	public Msg getSSN(@PathVariable(value="strPlantCode")String plant,@PathVariable(value="strSSN")String ssn) {
		logger.info("strPlantCode:"+plant+",strSSN:"+ssn);
		Map<String,String> map = new HashMap<String,String>();
		map.put("plant", plant);
		map.put("ssn", ssn);
		map.put("retflag", "");
		map.put("retmsg", "");
		Msg msg =new Msg();
		try {
			dao.getSSNStatus( map);
		} catch (Exception e) {
			msg.setRetflag("1");
			String errorMsg = e.getCause().toString();
			logger.error(errorMsg);
			int length=errorMsg.length();
			msg.setRetmsg(length>200?errorMsg.substring(0, 200):errorMsg);
			return msg;
		}
		msg.setRetflag(map.get("retflag"));
		msg.setRetmsg(map.get("retmsg"));
		return msg;
	}
	@RequestMapping(value="", method=RequestMethod.POST,consumes="application/json; charset=UTF-8",produces = "application/json; charset=UTF-8") 
	public Msg updateSSN(@RequestBody Result result){
		logger.info(result.toString());
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
		try {
			dao.updateSSNStatus(map);
		} catch (Exception e) {
			msg.setRetflag("1");
			String errorMsg = e.getCause().toString();
			logger.error(errorMsg);
			int length=errorMsg.length();
			msg.setRetmsg(length>200?errorMsg.substring(0, 200):errorMsg);
			return msg;
		}
		msg.setRetflag(map.get("retflag"));
		msg.setRetmsg(map.get("retmsg"));
		return msg;
		
	}
	

}
