package dmucs.dmu.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger;


@Slf4j
@Service
public class MealService {
    final String mealAddress = "https://www.dongyang.ac.kr/dongyang/130/subview.do?enc=Zm5jdDF8QEB8JTJGZGlldCUyRmRvbmd5YW5nJTJGMSUyRnZpZXcuZG8lM0Ztb25kYXklM0QyMDIzLjAxLjIzJTI2d2VlayUzRHByZSUyNg%3D%3D";

    public String[][] getThisWeekMeal () {
        Connection conn = Jsoup.connect(mealAddress);
        String[][] meal = new String[2][5];
        try{
            Document document = conn.get();
            meal = getTableBody(document);
        } catch (IOException e) {
            log.trace(e.getMessage());
        }


        return meal;
    }

    public String[][] getTableBody(Document document) {
        Elements stockTableBody = document.select("table tbody tr");  // 주간 학식 테이블 가져오기
        String[][] meal = new String[2][5];  // 담을 공간
        String tableGrade;  // 식당 구분
        int i = 0;
        for (Element element : stockTableBody) {  // 한 줄
            Elements tableRow = element.select("td");  //식단상세

            if (!tableRow.get(1).text().equals("-")) {
                tableGrade = tableRow.get(0).text();  //식당구분

                if (tableGrade.equals("학생식당")) {
                    meal[0][i] = tableRow.get(2).text();

                } else if (tableGrade.equals("교직원식당")) {
                    meal[1][i] = tableRow.get(2).text();
                    i++;
                }
            }
        }
        return meal;
    }
}
