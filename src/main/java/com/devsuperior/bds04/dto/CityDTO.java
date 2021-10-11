package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;

public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String name;
	
	private List<EventDTO> events = new ArrayList<>();
	
	public CityDTO() {
	}

	public CityDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CityDTO(City entity) {
		id = entity.getId();
		name = entity.getName();
		entity.getEvents().forEach(event -> events.add(new EventDTO(event)));
	}
	
	public CityDTO(City entity, Set<Event> events) {
		this(entity);
		events.forEach(event -> this.events.add(new EventDTO(event)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EventDTO> getEvents() {
		return events;
	}
}
