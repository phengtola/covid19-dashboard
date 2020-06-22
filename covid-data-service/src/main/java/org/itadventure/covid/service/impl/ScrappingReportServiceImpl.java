package org.itadventure.covid.service.impl;

import org.itadventure.covid.service.ScrappingReportService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ScrappingReportServiceImpl implements ScrappingReportService {


    @Override
    public void scrappingData() {

        System.out.println("Start scrappingData");
        Document doc;

        try {
            for(int i=0; i <= 2780; i++){
                System.out.println(i);
                i += 4;
            }
            /*doc = Jsoup.connect("http://samdechhunsen.gov.kh/index.php?limit=5&start=0").get();
            Elements divs = doc.select("div.blog-items");
            //System.out.println(divs);
            Elements items = divs.select("div.blog-item");

            int i=1;

            for (Element item : items) {

                Elements header = item.getElementsByTag("header");
                Elements a = header.select("h2 a");
                System.out.println(i  + "  ---- " + a.attr("href"));
                System.out.println(i  + "  ---- " + a.text());
                i += 1;

            }*/



        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("End scrappingData");


        }


}
