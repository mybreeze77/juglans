package com.juglans.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LogStep extends BaseLog {

	public LogStep(String content) {
		super(content);
	}
	
	@Override
	public String getContent() {
		return String.format("<p>%s</p>", super.getContent());
	}
	
	public String getContentWithTime(String format) {
		return String.format("<p>[%s] %s</p>", getReadableTime(format), super.getContent());
	}

	public String getReadableTime(String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(super.getTime());
	}
	
}
