package org.foxconn.service;

import org.foxconn.entity.Msg;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
* @author:myz
* @version 1.0 
* ����ʱ�䣺2018��5��26�� ����9:36:05
*/
@RestController
@RequestMapping("/efoxsfcSSNSTATUS")
public class ErrorService {
	//���û����벻����ʱ������ʾ
	@RequestMapping(value="", method=RequestMethod.GET,produces = "application/json; charset=UTF-8") 
	@ResponseBody
	public Msg getSSNResponse() {
		Msg msg =new Msg();
		msg.setRetflag("1");
		msg.setRetmsg("please input SN,example:.../efoxsfcSSNSTATUS/plant/sn");
		return msg;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET,produces = "application/json; charset=UTF-8") 
	@ResponseBody
	public Msg getSSN() {
		Msg msg =new Msg();
		msg.setRetflag("1");
		msg.setRetmsg("please input SN,example:.../efoxsfcSSNSTATUS/plant/sn");
		return msg;
	}
	@RequestMapping(value="/{strPlantCode}", method=RequestMethod.GET,produces = "application/json; charset=UTF-8") 
	@ResponseBody
	public Msg getSSN(@PathVariable(value="strPlantCode")String plant) {
		Msg msg =new Msg();
		msg.setRetflag("1");
		msg.setRetmsg("please input SN,example:.../efoxsfcSSNSTATUS/"+plant+"/sn");
		return msg;
	}
}
