package org.itadventure.covid.service.impl;

import org.itadventure.covid.entity.WorldCovidData;
import org.itadventure.covid.entity.WorldSumCovidData;
import org.itadventure.covid.repository.WorldCovidDataRepo;
import org.itadventure.covid.repository.WorldSumCovidDataRepo;
import org.itadventure.covid.service.ScrappingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class ScrappingServiceImpl implements ScrappingService {

    @Autowired
    private WorldSumCovidDataRepo worldSumCovidDataRepo;

    @Autowired
    private WorldCovidDataRepo worldCovidDataRepo;

    @Override
    public void scrappingData() {
        System.out.println("Start scrappingData");
        Document doc;
        try {
            doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
            Elements trs = doc.select("table#main_table_countries_today tr");

            Element trLast  = trs.get(trs.size()-1);
            Elements tdsLast = trLast.getElementsByTag("td");

            WorldSumCovidData worldSumCovidData = new WorldSumCovidData();
            worldSumCovidData.setId(1);
            worldSumCovidData.setTotalCases(Long.parseLong(tdsLast.get(1).text().replace(",","")));
            worldSumCovidData.setNewCases(Long.parseLong(tdsLast.get(2).text().replace(",","")));
            worldSumCovidData.setTotalDeaths(Long.parseLong(tdsLast.get(3).text().replace(",","")));
            worldSumCovidData.setNewDeaths(Long.parseLong(tdsLast.get(4).text().replace(",","")));
            worldSumCovidData.setTotalRecovered(Long.parseLong(tdsLast.get(5).text().replace(",","")));
            worldSumCovidData.setActiveCases(Long.parseLong(tdsLast.get(6).text().replace(",","")));
            worldSumCovidData.setSeriousCritical(Long.parseLong(tdsLast.get(7).text().replace(",","")));
            worldSumCovidData.setTotCases1mPop(Double.parseDouble(tdsLast.get(8).text().replace(",","")));
            worldSumCovidData.setTotDeaths1mPop(Double.parseDouble(tdsLast.get(9).text().replace(",","")));
            worldSumCovidData.setUpdatedAt(LocalDateTime.now());
            System.out.println(worldSumCovidData.toString());
            worldSumCovidDataRepo.save(worldSumCovidData);


            //remove header row
            trs.remove(0);

            //remove last tr
            trs.remove(trs.get(trs.size()-1));

            for (Element tr : trs) {
                Elements tds = tr.getElementsByTag("td");
                //Element td = tds.first();
                WorldCovidData worldCovidData = new WorldCovidData();
                worldCovidData.setCountry(tds.get(0).text());
                try {
                    worldCovidData.setTotalCases(Long.parseLong(tds.get(1).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setNewCases(Long.parseLong(tds.get(2).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setTotalDeaths(Long.parseLong(tds.get(3).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setNewDeaths(Long.parseLong(tds.get(4).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setTotalRecovered(Long.parseLong(tds.get(5).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setActiveCases(Long.parseLong(tds.get(6).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setSeriousCritical(Long.parseLong(tds.get(7).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setTotCases1mPop(Double.parseDouble(tds.get(8).text().replace(",","")));
                }catch (Exception e){}
                try {
                    worldCovidData.setTotDeaths1mPop(Double.parseDouble(tds.get(9).text().replace(",","")));
                }catch (Exception e){}

                worldCovidData.setUpdatedAt(LocalDateTime.now());
                System.out.println(worldCovidData.toString());
                worldCovidDataRepo.save(worldCovidData);
            }
            System.out.println("********* End ScrappingData *********** ");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}





        /*System.out.print("Total : " + tdsLast.get(0).text());
        System.out.print(" - total_cases : " + tdsLast.get(1).text());
        System.out.print(" - new_cases : " + tdsLast.get(2).text());
        System.out.print(" - total_deaths : " + tdsLast.get(3).text());
        System.out.print(" - new_deaths : " + tdsLast.get(4).text());
        System.out.print(" -total_recovered : " + tdsLast.get(5).text());
        System.out.print(" - active_cases : " + tdsLast.get(6).text());
        System.out.print(" - serious_cases : " + tdsLast.get(7).text());
        System.out.println(" - tot_cases_1m_pop : " + tdsLast.get(8).text());
        System.out.println(" -tot_deaths_1m_pop : " + tdsLast.get(9).text());*/