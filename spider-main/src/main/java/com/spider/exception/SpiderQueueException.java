package com.spider.exception;

public class SpiderQueueException extends Exception {

	private static final long serialVersionUID = -6019799403608343990L;

	public SpiderQueueException(String message, Throwable cause){
		super(message, cause);
	}

	public SpiderQueueException(String message){
		super(message);
	}

	public SpiderQueueException(){
		super();
	}

	public SpiderQueueException(Throwable cause){
		super(cause);
	}
}
