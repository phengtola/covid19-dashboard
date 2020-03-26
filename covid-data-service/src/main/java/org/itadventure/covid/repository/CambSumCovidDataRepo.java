package org.itadventure.covid.repository;

import org.itadventure.covid.entity.CambSumCovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambSumCovidDataRepo extends JpaRepository<CambSumCovidData, Long> {
}
