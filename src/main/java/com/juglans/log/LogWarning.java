package com.juglans.log;

public class LogWarning extends BaseLog {

	public LogWarning(String content) {
		super(content);
	}
	
	@Override
	public String getContent() {
		return String.format("<p><font color=yellow>%s</font></p>", super.getContent());
	}
	
}
