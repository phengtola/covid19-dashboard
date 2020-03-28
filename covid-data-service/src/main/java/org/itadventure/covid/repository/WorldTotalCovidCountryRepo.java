package org.itadventure.covid.repository;

import org.itadventure.covid.entity.WorldTotalCovidCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldTotalCovidCountryRepo extends JpaRepository<WorldTotalCovidCountry , Long> {

    WorldTotalCovidCountry findByCountryEn(String countryEn);

}
