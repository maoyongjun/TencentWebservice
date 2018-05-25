package org.foxconn.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
* @author:myz
* @version 1.0 
* 创建时间：2018年5月25日 下午9:16:20
*/
@XmlRootElement
public class TestResult implements Serializable{
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
