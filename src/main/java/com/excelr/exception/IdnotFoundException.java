package com.excelr.exception;

public class IdnotFoundException extends RuntimeException {
	
	private String msg;

	public IdnotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
	
	

}
