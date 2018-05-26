package org.foxconn.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月26日 上午9:26:57
*/
@RestController
public class IndexService {
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String  index(){
		return "";
	}
}
