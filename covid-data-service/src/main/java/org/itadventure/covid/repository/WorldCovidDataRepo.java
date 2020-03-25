package org.itadventure.covid.repository;

import org.itadventure.covid.entity.WorldCovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldCovidDataRepo extends JpaRepository<WorldCovidData , Long> {

}
