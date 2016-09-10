package com.juglans.log;

public class LogHidden extends BaseLog {

	public LogHidden(String content) {
		super(content);
	}
	
	@Override
	public String getContent() {
		return String.format("<p style=\"display:none\">%s</p>", super.getContent());
	}
	
}
