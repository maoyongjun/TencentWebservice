package org.foxconn.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
* @author:myz
* @version 1.0 
* ����ʱ�䣺2018��5��25�� ����9:18:27
*/
@XmlRootElement
public class UpdateResultMessage implements Serializable{
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
