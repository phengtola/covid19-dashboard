package org.itadventure.covid.service.impl;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        this.scrapDetail("");

        Document doc;

        try {

            //this.getImages("http://www.samdechhunsen.gov.kh/images/05-06-2020/101259017_3046564105392066_5478644902499713024_o.jpg","/Users/tola/file/scrap");

            /*for(int i=0; i <= 2780; i++){
                System.out.println(i);
                i += 4;
            }*/
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

        System.out.println("End ScrappingData");


    }



    private void scrapDetail(String url){
        try {
            Document doc;
            doc = Jsoup.connect("http://www.samdechhunsen.gov.kh/index.php/3188-2020-06-10-16-00-20").get();
            Elements header = doc.getElementsByTag("header");
            Elements a = header.select("h1 a");
            System.out.println( "  ---- " + a.text());

            Elements time = doc.getElementsByTag("time");
            //System.out.println(this.changeDateFormat(time.attr("datetime"), "yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd"));
            String dd = time.attr("datetime").split("T")[0];
            System.out.println( "  ---- " + dd);

            Elements pList = doc.select("section.article-content p");
            for (Element p : pList) {
                //System.out.println(p.childrenSize());

                if(p.childrenSize() == 0){
                    System.out.println( p.childrenSize() + "   ---- " + p.text());
                }else {
                    System.out.println( p.childrenSize() + "  ---- " + p.getElementsByTag("img"));
                }

                /*if(p.getElementsByTag("img") != null){
                    System.out.println( "  ---- " + p.getElementsByTag("img"));
                }*/
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    private static void getImages(String src , String imgDestination) throws IOException {

        String folder = null;

        //Exctract the name of the image from the src attribute
        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }

        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());

        System.out.println(name);

        //Open a URL Stream
        URL url = new URL(src);
        InputStream in = url.openStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream( imgDestination + "/" + name));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();

    }

    public String changeDateFormat(String  dateTime, String fromFormat, String toFormat)  {
        SimpleDateFormat frmFrmat = new SimpleDateFormat(fromFormat);
        SimpleDateFormat toFrmat = new SimpleDateFormat(toFormat);
        Date date = null;
        String date1 = "";
        try {
            date = frmFrmat.parse(dateTime);
            date1 = toFrmat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }





}
