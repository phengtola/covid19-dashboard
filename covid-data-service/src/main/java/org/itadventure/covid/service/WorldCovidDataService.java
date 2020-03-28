package org.itadventure.covid.service;

import org.itadventure.covid.entity.WorldTotalCovidCountry;
import org.itadventure.covid.entity.WorldSumCovidData;

import java.util.List;

public interface WorldCovidDataService {

    WorldSumCovidData findTotal();
    List<WorldTotalCovidCountry> findAll();
}
