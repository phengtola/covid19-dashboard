package org.itadventure.covid.service;

import org.itadventure.covid.entity.WorldCovidData;
import org.itadventure.covid.entity.WorldSumCovidData;

import java.util.List;

public interface WorldCovidDataService {

    WorldSumCovidData findTotal();
    List<WorldCovidData> findAll();
}
