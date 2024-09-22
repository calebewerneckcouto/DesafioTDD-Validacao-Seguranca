package com.cwcdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cwcdev.dto.EventDTO;
import com.cwcdev.entities.City;
import com.cwcdev.entities.Event;
import com.cwcdev.respository.CityRepository;
import com.cwcdev.respository.EventRepository;

@Service
public class EventServices {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private CityRepository cityRepository;
	
	public Page<EventDTO> lista(Pageable pageable) {
		 Page<Event> page = repository.findAll(pageable);
		 return  page.map(event -> new EventDTO(event));
	}
	
	public EventDTO adiciona(EventDTO dto) {
		Event event = new Event();
		event.setName(dto.getName());
		event.setUrl(dto.getUrl());
		event.setDate(dto.getDate());
		
		City city = cityRepository.findById(dto.getCityId()).orElseThrow();
		event.setCity(city);
		
		return new EventDTO(repository.save(event));
	}
}
