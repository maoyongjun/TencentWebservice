package org.foxconn.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月25日 下午9:15:03
*/
@XmlRootElement
public class ResultMessage implements Serializable{
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
