package com.juglans.log;

import java.sql.Timestamp;

/**
 * Basic log POJO
 * @author Junlong Wu
 *
 */
public class BaseLog {

	private String content;
	private Timestamp time;
	
	public BaseLog() {
		super();
	}
	
	public BaseLog(String content) {
		super();
		this.content = content;
		this.time = new Timestamp(System.currentTimeMillis());
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
