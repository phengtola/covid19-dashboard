package org.itadventure.covid.service.impl;

import org.itadventure.covid.controller.response.ApiResponse;
import org.itadventure.covid.controller.response.ResourceNotFoundException;
import org.itadventure.covid.entity.WorldCovidData;
import org.itadventure.covid.entity.WorldSumCovidData;
import org.itadventure.covid.repository.WorldCovidDataRepo;
import org.itadventure.covid.repository.WorldSumCovidDataRepo;
import org.itadventure.covid.service.WorldCovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorldCovidDataServiceImpl  implements WorldCovidDataService {

    @Autowired
    private WorldSumCovidDataRepo worldSumCovidDataRepo;
    @Autowired
    private WorldCovidDataRepo worldCovidDataRepo;

    @Override
    public WorldSumCovidData findTotal(){
        WorldSumCovidData worldSumCovidData = null;
        if( worldSumCovidDataRepo.existsById(1L)){
            worldSumCovidData = worldSumCovidDataRepo.findById(1L).get();
        }
        return worldSumCovidData;
    }

    @Override
    public List<WorldCovidData> findAll() {
        return worldCovidDataRepo.findAll();
    }
}
