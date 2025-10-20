package com.seing.security;

import com.seing.security.domain.Car;
import com.seing.security.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	private final CarRepository repository;

	public CarController(CarRepository repository) {
		this.repository = repository;
	}
	
//	@GetMapping("/")
//	public String index() {
//		return "Home";
//	}

	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}
}
