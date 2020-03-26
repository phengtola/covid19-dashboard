package org.itadventure.covid.service;

import org.itadventure.covid.entity.CambSumCovidData;
import org.itadventure.covid.entity.CambTotalCovidDataProvince;

import java.util.List;

public interface CambodiaCovidDataService {
    CambSumCovidData findTotal();
    List<CambTotalCovidDataProvince> findAll();
}
