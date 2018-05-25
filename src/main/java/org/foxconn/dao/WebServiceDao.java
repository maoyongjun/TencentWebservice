package org.foxconn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.foxconn.entity.ResultMessage;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月25日 下午9:14:00
*/
@Mapper
public interface WebServiceDao {
	public ResultMessage getSSNStatus(); 
//	public UpdateResultMessage updateSSNStatus(TestResult testResult);
}
