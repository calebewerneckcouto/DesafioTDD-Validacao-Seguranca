package com.cwcdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cwcdev.dto.CityDTO;
import com.cwcdev.service.CityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityService service;
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public CityDTO adiciona(@Valid @RequestBody CityDTO cityDTO) {
		return service.adiciona(cityDTO);
	}
	
	@GetMapping
	public List<CityDTO> adiciona() {
		return service.lista();
	}
}
