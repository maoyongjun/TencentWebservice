package org.foxconn.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* @author:myz
* @version 1.0 
* ����ʱ�䣺2018��5��26�� ����9:26:57
*/
@Controller
public class IndexService {
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String  index(){
		return "index.html";
	}
}
