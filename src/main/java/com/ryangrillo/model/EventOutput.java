package com.ryangrillo.model;

import java.util.Date;

public class EventOutput {
	
	private String type;
	
	private Date created;

	public EventOutput() {}
	

	public EventOutput(String type, Date created) {
		super();
		this.type = type;
		this.created = created;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	

}
