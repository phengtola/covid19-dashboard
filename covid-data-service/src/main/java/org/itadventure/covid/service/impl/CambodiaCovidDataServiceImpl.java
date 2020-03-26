package org.itadventure.covid.service.impl;

import org.itadventure.covid.controller.response.ResourceNotFoundException;
import org.itadventure.covid.entity.CambSumCovidData;
import org.itadventure.covid.entity.CambTotalCovidDataProvince;
import org.itadventure.covid.entity.WorldCovidData;
import org.itadventure.covid.entity.WorldSumCovidData;
import org.itadventure.covid.repository.CambSumCovidDataRepo;
import org.itadventure.covid.repository.CambTotalCovidDataProvinceRepo;
import org.itadventure.covid.repository.WorldCovidDataRepo;
import org.itadventure.covid.repository.WorldSumCovidDataRepo;
import org.itadventure.covid.service.CambodiaCovidDataService;
import org.itadventure.covid.service.WorldCovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CambodiaCovidDataServiceImpl implements CambodiaCovidDataService {

    @Autowired
    private CambSumCovidDataRepo cambSumCovidDataRepo;
    @Autowired
    private CambTotalCovidDataProvinceRepo cambTotalCovidDataProvinceRepo;

    @Override
    public CambSumCovidData findTotal() {
        CambSumCovidData cambSumCovidData = null;
        if(cambSumCovidDataRepo.existsById(1L)){
            cambSumCovidData = cambSumCovidDataRepo.findById(1L).get();
        }
        return cambSumCovidData;
    }

    @Override
    public List<CambTotalCovidDataProvince> findAll() {
        return cambTotalCovidDataProvinceRepo.findAll();
    }
}
