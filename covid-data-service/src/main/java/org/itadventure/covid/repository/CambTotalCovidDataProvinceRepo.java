package org.itadventure.covid.repository;

import org.itadventure.covid.entity.CambTotalCovidDataProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambTotalCovidDataProvinceRepo extends JpaRepository<CambTotalCovidDataProvince, Long> {
}
