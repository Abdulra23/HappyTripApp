package com.myapp.happytrip.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.happytrip.model.Profile;
public interface ProfileList extends JpaRepository<Profile, Integer>{

	Optional<List<Profile>> findByphoneNumber(Integer phoneNumber);
}