package org.itadventure.covid.controller;

import org.itadventure.covid.controller.response.ApiResponse;
import org.itadventure.covid.controller.response.ResourceNotFoundException;
import org.itadventure.covid.entity.CambSumCovidData;
import org.itadventure.covid.entity.CambTotalCovidDataProvince;
import org.itadventure.covid.entity.WorldCovidData;
import org.itadventure.covid.entity.WorldSumCovidData;
import org.itadventure.covid.repository.WorldCovidDataRepo;
import org.itadventure.covid.repository.WorldSumCovidDataRepo;
import org.itadventure.covid.service.CambodiaCovidDataService;
import org.itadventure.covid.service.WorldCovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("itadventure/api/covid")
public class CovidRestController {

    @Autowired
    private WorldCovidDataService worldCovidDataService;

    @Autowired
    private CambodiaCovidDataService cambodiaCovidDataService;

    @RequestMapping("/world")
    public ApiResponse<WorldSumCovidData> findWorldTotalCovidData(){
        WorldSumCovidData worldSumCovidData = worldCovidDataService.findTotal();
        if(worldSumCovidData == null){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<>(worldSumCovidData);
    }

    @RequestMapping("/world/country")
    public ApiResponse<List<WorldCovidData>> findWorldCovidData(){
        return new ApiResponse<>(worldCovidDataService.findAll());
    }

    @RequestMapping("/cambodia")
    public ApiResponse<CambSumCovidData> findCambSumCovidData(){
        CambSumCovidData cambSumCovidData = cambodiaCovidDataService.findTotal();
        if(cambSumCovidData == null){
            return new ApiResponse<>("404","No data!");
        }
        return new ApiResponse<>("200","Success",cambSumCovidData);
    }

    @RequestMapping("/cambodia/province")
    public ApiResponse<List<CambTotalCovidDataProvince>> findCambTotalCovidDataProvince(){
        return new ApiResponse<>("200","Success",cambodiaCovidDataService.findAll());
    }
}
