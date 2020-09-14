package com.runadium.runadoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.runadium.runadoc.model.RendezVous;

@Repository
public interface RendezVousRepository {

	
	@Query(value = "SELECT * FROM rendezvous WHERE user_id = :userId", nativeQuery = true)
	List<RendezVous> getMyRendezVous(@Param("userId") Long userId);

	
}
