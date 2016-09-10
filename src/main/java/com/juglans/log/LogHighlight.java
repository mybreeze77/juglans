package com.juglans.log;

public class LogHighlight extends BaseLog {

	public LogHighlight(String content) {
		super(content);
	}
	
	@Override
	public String getContent() {
		return String.format("<p><b>%s</b></p>", super.getContent());
	}
	
}
