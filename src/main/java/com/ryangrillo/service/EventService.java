package com.ryangrillo.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ryangrillo.model.Event;
import com.ryangrillo.model.EventOutput;

public interface EventService {

	EventOutput createEvent(@Valid Event event, String userEmail);

	Map<String, List<Event>> getAllEvents(String userEmail, boolean lastDayEvents);

}
