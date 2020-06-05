package com.zhengke.common.exception;

public class LoginErrorException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LoginErrorException(){}
	public LoginErrorException(String msg){
		super(msg);
	}
	public LoginErrorException(String msg,Throwable cause){
		super(msg,cause);
	}
}
