package com.duanpj.test.base;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseEntity implements Serializable {

	private boolean result;
	private String msg;
	private String data;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
