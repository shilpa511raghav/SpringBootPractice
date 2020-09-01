package com.libraryManagement.dataformat;

import com.libraryManagement.model.UserModel;

public class Response {
	String ECR;
	String ERR;
	UserModel response;
	public String getECR() {
		return ECR;
	}
	public void setECR(String eCR) {
		ECR = eCR;
	}
	public String getERR() {
		return ERR;
	}
	public void setERR(String eRR) {
		ERR = eRR;
	}
	public UserModel getResponse() {
		return response;
	}
	public void setResponse(UserModel response) {
		this.response = response;
	}
	

}
