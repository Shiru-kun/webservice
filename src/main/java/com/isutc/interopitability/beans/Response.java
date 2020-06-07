package com.isutc.interopitability.beans;

import com.isutc.interopitability.modelEnum.Result;

public class Response {
 
	private String codInstReqName;
	private String codInstRespName;
	private String infoName;
	private String result;
	private String obs;
	public String getCodInstReq() {
		return codInstReqName;
	}
	public void setCodInstReq(String codInstReq) {
		this.codInstReqName = codInstReq;
	}
	public String getCodInstResp() {
		return codInstRespName;
	}
	public void setCodInstResp(String codInstResp) {
		this.codInstRespName = codInstResp;
	}
	public String getInfoName() {
		return infoName;
	}
	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Response(String codInstReq, String codInstResp, String infoName, String result, String obs) {
		super();
		
		this.codInstReqName = codInstReq;
		this.codInstRespName = codInstResp;
		this.infoName = infoName;
		this.result = result;
		this.obs = obs;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
