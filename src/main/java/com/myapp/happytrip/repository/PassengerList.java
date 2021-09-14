package com.myapp.happytrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.happytrip.model.Passenger;

@Repository
public interface PassengerList extends JpaRepository<Passenger, Integer> {

}
