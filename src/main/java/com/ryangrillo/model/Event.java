package com.ryangrillo.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event {
	
	@ApiModelProperty(required = true)
	@NotNull(message = "type cannot be null")
	private String type;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@ApiModelProperty(hidden = true)
	private Date created;

	public Event() {}

	public Event(String type, Date created) {
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

	@Override
	public String toString() {
		return "Event [type=" + type + ", created=" + created + "]";
	}
	
	








	
	
	

}
