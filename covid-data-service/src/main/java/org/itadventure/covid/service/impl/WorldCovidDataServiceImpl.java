package org.itadventure.covid.service.impl;

import org.itadventure.covid.entity.WorldTotalCovidCountry;
import org.itadventure.covid.entity.WorldSumCovidData;
import org.itadventure.covid.repository.WorldSumCovidDataRepo;
import org.itadventure.covid.repository.WorldTotalCovidCountryRepo;
import org.itadventure.covid.service.WorldCovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldCovidDataServiceImpl  implements WorldCovidDataService {

    @Autowired
    private WorldSumCovidDataRepo worldSumCovidDataRepo;
    @Autowired
    private WorldTotalCovidCountryRepo worldTotalCovidCountryRepo;

    @Override
    public WorldSumCovidData findTotal(){
        WorldSumCovidData worldSumCovidData = null;
        if( worldSumCovidDataRepo.existsById(1L)){
            worldSumCovidData = worldSumCovidDataRepo.findById(1L).get();
        }
        return worldSumCovidData;
    }

    @Override
    public List<WorldTotalCovidCountry> findAll() {
        return worldTotalCovidCountryRepo.findAll();
    }
}
