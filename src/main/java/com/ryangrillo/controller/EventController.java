package com.ryangrillo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ryangrillo.model.Event;
import com.ryangrillo.model.EventOutput;
import com.ryangrillo.service.EventService;


@RestController
public class EventController {
	
	 Logger logger = LoggerFactory.getLogger(EventController.class);
	
	private EventService eventService;

	@Autowired
	EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
    @ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/event")
	public @Valid EventOutput createEvent(@Valid @RequestBody Event event, @RequestHeader(required = true) String userEmail) {
		logger.info("create event with fields {} and userEmail: {}", event.toString(), userEmail);
    	return eventService.createEvent(event, userEmail);
	}
    
    @GetMapping("/events")
    public Map<String, List<Event>> getAllEvents(@RequestParam (value = "userEmail", required = false) String userEmail,
    											 @RequestParam (value = "lastDayEvents", required = false, defaultValue = "false") boolean lastDayEvents) {
    	logger.info("get all events with userEmail {}, and lastDayEvents set to {}", userEmail, lastDayEvents );
    	return eventService.getAllEvents(userEmail, lastDayEvents);
    }
    
    

}
