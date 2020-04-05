package com.ryangrillo.controller;

import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.ArgumentMatchers.any;
import com.ryangrillo.exception.ResourceNotFoundException;
import com.ryangrillo.model.Event;
import com.ryangrillo.model.EventOutput;
import com.ryangrillo.service.EventService;

@RunWith(SpringRunner.class)
public class EventControllerTest {
	
	@Mock
	private EventService eventService;
	
	@InjectMocks
	private EventController eventController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		eventController = new EventController(eventService);
	}
	
	@Test
	public void test_create_event() {
		Date d = new Date();
		EventOutput expectedEventOutput =  new EventOutput("type", d);
		when(eventService.createEvent(any(), any())).thenReturn(new EventOutput("type", d));
		@Valid EventOutput actualEventOutput = eventController.createEvent(new Event("type", d), "a@a.com");
		assertEquals(expectedEventOutput.getType(), actualEventOutput.getType());
	}
	
	@Test
	public void get_all_events() {
		Map<String, List<Event>> expectedOutput = new HashMap<>();
		when(eventService.getAllEvents("user@user.com", true)).thenReturn(expectedOutput);
		Map<String, List<Event>> actualOutput = eventController.getAllEvents("user@user.com", true);
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void get_all_events_throws_Resource_not_found_exception() {
		Map<String, List<Event>> expectedOutput = new HashMap<>();
		when(eventService.getAllEvents("user@user.com", true)).thenThrow(new ResourceNotFoundException(""));
		Map<String, List<Event>> actualOutput = eventController.getAllEvents("user@user.com", true);
		assertEquals(expectedOutput, actualOutput);
	}

}
