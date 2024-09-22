package com.cwcdev.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwcdev.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
