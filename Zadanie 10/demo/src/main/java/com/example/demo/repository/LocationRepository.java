package com.example.demo.repository;

import com.example.demo.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "locations", collectionResourceRel = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {

    // Wyszukiwanie po kraju
    Page<Location> findByCountry(@Param("country") String country, Pageable pageable);

    // Wyszukiwanies po nazwie miasta
    Optional<Location> findByCity(@Param("city") String city);
}
