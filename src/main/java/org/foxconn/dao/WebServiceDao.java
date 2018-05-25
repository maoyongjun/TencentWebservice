package org.foxconn.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.foxconn.entity.Msg;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月25日 下午9:14:00
*/
@Mapper
public interface WebServiceDao {
	public void getSSNStatus(Map<String,String> map); 
	public void updateSSNStatus(Map<String,String> map);
}
