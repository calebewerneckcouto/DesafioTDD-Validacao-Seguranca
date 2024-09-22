package com.cwcdev.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwcdev.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
