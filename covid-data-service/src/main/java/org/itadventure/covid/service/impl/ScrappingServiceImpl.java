package org.itadventure.covid.service.impl;

import org.itadventure.covid.entity.WorldSumCovidData;
import org.itadventure.covid.entity.WorldTotalCovidCountry;
import org.itadventure.covid.repository.WorldSumCovidDataRepo;
import org.itadventure.covid.repository.WorldTotalCovidCountryRepo;
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
    private WorldTotalCovidCountryRepo worldTotalCovidCountryRepo;

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
            if(worldSumCovidDataRepo.existsById(1L)){
                worldSumCovidData.setId(1L);
            }
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
                WorldTotalCovidCountry worldCovidData = new WorldTotalCovidCountry();
                worldCovidData.setCountryId(
                        tds.get(0).text()
                                .replaceAll("\\s+","_")
                                .replace(".","")
                                .replace("-","_")
                                .toLowerCase().trim()
                );
                worldCovidData.setCountryEn(tds.get(0).text());
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

                WorldTotalCovidCountry worldTotalCovidCountryUpdate = worldTotalCovidCountryRepo.findByCountryEn(worldCovidData.getCountryEn());
                if(worldTotalCovidCountryUpdate != null){
                    System.out.println("********* UPDATE *********** ");
                    worldCovidData.setId(worldTotalCovidCountryUpdate.getId());
                    worldTotalCovidCountryRepo.save(worldCovidData);
                }else {
                    System.out.println("********* INSERT *********** ");
                    worldTotalCovidCountryRepo.save(worldCovidData);
                }


            }
            System.out.println("********* End ScrappingData *********** ");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void scrappingCambodiaCovidData() {
        Document doc;
        System.out.println("********* ScrappingData *********** ");
        try {
            doc = Jsoup.connect("https://en.wikipedia.org/wiki/2020_coronavirus_pandemic_in_Cambodia").get();

            Elements trs = doc.select("table.wikitable").get(1).select("tbody tr");

            for (Element tr : trs) {
                Elements tds = tr.getElementsByTag("td");
                System.out.println(" case : " + tds.text());

            }
            /*for (Element element : tableElements) {
                Elements data = element.select("td");
                System.out.println(data.text());
                *//*System.out.print(" case : " + data.get(0).text());
                System.out.print(" date : " + data.get(1).text());
                System.out.print(" age : " + data.get(2).text());
                System.out.print(" gender : " + data.get(3).text());
                System.out.println(" nationality : " + data.get(4).text());*//*
            }*/

            //remove header row
            //trs.remove(0);

            /*for (Element tr : trs) {
                Elements tds = tr.getElementsByTag("td");
                System.out.println(" case : " + tds.get(0).text());
            }*/

        }catch (Exception e){
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