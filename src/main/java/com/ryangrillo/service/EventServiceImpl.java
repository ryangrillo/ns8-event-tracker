package com.ryangrillo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ryangrillo.constants.Constants;
import com.ryangrillo.exception.ResourceNotFoundException;
import com.ryangrillo.model.Event;
import com.ryangrillo.model.EventOutput;
import com.ryangrillo.util.DateUtil;

@Service
public class EventServiceImpl implements EventService{
	
	 
	private UserServiceImple userService;
	
	@Autowired
	EventServiceImpl (UserServiceImple userService) {
		this.userService = userService;
	}

	private static Map<String, List<Event>> userEventMap = new HashMap<>();

	@Override
	public EventOutput createEvent(@Valid Event event, @RequestHeader String userEmail) {
		validateUserExists(userEmail);
		List<Event> events = userEventMap.get(userEmail);
		if (events == null) {
			events = new ArrayList<Event>();
			userEventMap.put(userEmail, events);
		}
		event.setCreated(DateUtil.randomTodayOrYesterday());
		events.add(event);
		userEventMap.put(userEmail, events);
		return new EventOutput(event.getType(), event.getCreated());
	}

	@Override
	public Map<String, List<Event>> getAllEvents(String userEmail, boolean lastDayEvents) {
		if (!StringUtils.isEmpty(userEmail) && lastDayEvents == false) {
			validateUserExists(userEmail);
			Map<String, List<Event>> mapByUser = new HashMap<String, List<Event>>();
			mapByUser.put(userEmail, userEventMap.get(userEmail));
			return mapByUser;
		}

		if (StringUtils.isEmpty(userEmail) && lastDayEvents == true) {
			Map<String, List<Event>> userEventMapPrevDay = new HashMap<>();
			for (Entry<String, List<Event>> userMap : userEventMap.entrySet()) {
				if (userMap.getValue() != null) {
					List<Event> events = userMap.getValue().stream().filter(e -> DateUtil.getYesterday(e.getCreated()))
							.collect(Collectors.toList());
					userEventMapPrevDay.put(userMap.getKey(), events);
				}
			}
			return userEventMapPrevDay;

		}
		if  (!StringUtils.isEmpty(userEmail) && lastDayEvents == true) {
			Map<String, List<Event>> userEventMapPrevDay = new HashMap<>();
			validateUserExists(userEmail);
			for (Entry<String, List<Event>> userMap : userEventMap.entrySet()) {
				if (userMap.getValue() != null) {
					List<Event> events = userMap.getValue().stream().filter(e -> DateUtil.getYesterday(e.getCreated()))
							.collect(Collectors.toList());
					userEventMapPrevDay.put(userMap.getKey(), events);
				}
			}	
			
			Map<String, List<Event>> mapByUserAndPrevDate = new HashMap<String, List<Event>>();
			mapByUserAndPrevDate.put(userEmail, userEventMapPrevDay.get(userEmail));
			return mapByUserAndPrevDate;
		}
		return userEventMap;

	}
	
	private void validateUserExists(String userEmail) {
		if (!userService.getUsers().stream().anyMatch(p -> p.getEmail().equalsIgnoreCase(userEmail))) {
			throw new ResourceNotFoundException(Constants.USER_EMAIL + userEmail + Constants.DOES_NOT_EXIST);
		}
	}
}
