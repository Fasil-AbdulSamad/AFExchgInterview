package com.alfardan.interview.modal;

public class BaseResponse {

	private String responseCode;
	private String responseDesc;

	public BaseResponse() {
	}

	public BaseResponse(String responseCode, String responseDesc) {
		this.responseCode = responseCode;
		this.responseDesc = responseDesc;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

}
