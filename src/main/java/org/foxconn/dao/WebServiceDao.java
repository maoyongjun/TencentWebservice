package org.foxconn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.foxconn.entity.ResultMessage;

/**
* @author:myz
* @version 1.0 
* ����ʱ�䣺2018��5��25�� ����9:14:00
*/
@Mapper
public interface WebServiceDao {
	public ResultMessage getSSNStatus(); 
//	public UpdateResultMessage updateSSNStatus(TestResult testResult);
}
