package dmucs.dmu.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MealService {
    final String mealAddress = "https://www.dongyang.ac.kr/dongyang/130/subview.do?enc=Zm5jdDF8QEB8JTJGZGlldCUyRmRvbmd5YW5nJTJGMSUyRnZpZXcuZG8lM0Ztb25kYXklM0QyMDIzLjAxLjIzJTI2d2VlayUzRHByZSUyNg%3D%3D";

    public ArrayList getThisWeekMeal () {
        Connection conn = Jsoup.connect(mealAddress);
        ArrayList<ArrayList<String>> meal = new ArrayList<>();
        try {
            Document document = conn.get();
            meal = getTableBody(document);
        } catch (IOException e) {

        }
        return meal;
    }

    public ArrayList getTableBody(Document document) {
        Elements stockTableBody = document.select("table tbody tr");  // 주간 학식 테이블 가져오기
        ArrayList<ArrayList<String>> meal = new ArrayList<>();  // 담을 공간
        String tableGrade;  // 식당 구분
        int i = 0;
        for (Element element : stockTableBody) {  // 한 줄
            Elements tableRow = element.select("td");  //식단상세
            tableGrade = tableRow.get(0).text();  //식당구분
            if (!tableRow.get(1).text().equals("-")) {
                if (tableGrade.equals("학생식당")) {
                    meal.get(0).set(i, tableRow.get(2).text());
                } else if (tableGrade.equals("교직원식당")) {
                    meal.get(1).set(i, tableRow.get(2).text());
                    i++;
                }
            }
        }
        return meal;
    }
}
