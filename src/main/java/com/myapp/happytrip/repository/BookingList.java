package com.myapp.happytrip.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.happytrip.model.Booking;

@Repository
public interface BookingList extends JpaRepository<Booking, String> {
	Optional<List<Booking>> findByfirstName(String name);
}