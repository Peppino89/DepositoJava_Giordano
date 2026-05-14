package org.example.eserciziojpa.repository;

import org.example.eserciziojpa.model.Location;
import org.example.eserciziojpa.model.Run;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RunRepository extends JpaRepository<Run, Integer> {

    List<Run> findByTitle(String title);
    List<Run> findByMilesGreaterThan(String miles);
    List<Run> findByLocation(String location);
    List<Run> findByLocationAndMilesGreaterThan(String location, String miles);
    Optional<Run> findFirstByTitle(String title);
    boolean existsByTitle(String title);

    @Query("SELECT r FROM Run r WHERE r.location = :location ORDER BY r.miles DESC")
    List<Run> findByLocationOrderedByMiles(@Param("location") Location location);

}
