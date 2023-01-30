package dmucs.dmu.weeklymeal;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class WyCroll {
    public void getThisWeekMeal () {
        final String mealWeb = "https://www.dongyang.ac.kr/dongyang/130/subview.do?enc=Zm5jdDF8QEB8JTJGZGlldCUyRmRvbmd5YW5nJTJGMSUyRnZpZXcuZG8lM0Ztb25kYXklM0QyMDIzLjAxLjIzJTI2d2VlayUzRHByZSUyNg%3D%3D";
        Connection conn = Jsoup.connect(mealWeb);
        try {
            Document document = conn.get();
            String thead = getTableBody(document);
            System.out.println(thead);
        } catch (IOException e) {

        }
    }

    public String getTableBody(Document document) {
        Elements stockTableBody = document.select("table tbody tr");
        String[] staff = new String[5];
        String[] student = new String[5];
        String tableGrade;
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (Element element : stockTableBody) {  // 한 줄
            Elements tableRow = element.select("td");  //식단상세
            tableGrade = tableRow.get(0).text();  //식당구분
            if (!tableRow.get(1).text().equals("-")) {
                if (tableGrade.equals("학생식당")) {
                    student[i] = tableRow.get(2).text();
                } else if (tableGrade.equals("교직원식당")) {
                    staff[i] = tableRow.get(2).text();
                    i++;
                }
            }
        }
        for(int n = 0; n < 5; n++){
            s.append(staff[n]);
            s.append("       ");
            s.append(student[n]);
            s.append("\n");
        }
        return s.toString();
    }
    public static void main(String[] args) {
        WyCroll wyCroll = new WyCroll();
        wyCroll.getThisWeekMeal();
    }

}
