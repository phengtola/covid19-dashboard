package org.itadventure.covid.repository;

import org.itadventure.covid.entity.WorldCovidData;
import org.itadventure.covid.entity.WorldSumCovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldSumCovidDataRepo extends JpaRepository<WorldSumCovidData, Long> {

}
