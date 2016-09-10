package com.juglans.log;

public class LogInfo extends BaseLog {

	public LogInfo(String content) {
		super(content);
	}
	
	@Override
	public String getContent() {
		return String.format("<p><font color=black>%s</font></p>", super.getContent());
	}
	
}
