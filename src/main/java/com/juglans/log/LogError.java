package com.juglans.log;

public class LogError extends BaseLog {

	public LogError(String content) {
		super(content);
	}
	
	@Override
	public String getContent() {
		return String.format("<p><font color=red>%s</font></p>", super.getContent());
	}
	
}
