package org.itadventure.covid.repository;

import org.itadventure.covid.entity.base.CambodiaCovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambodiaCovidDataRepo extends JpaRepository<CambodiaCovidData, Long> {

}
