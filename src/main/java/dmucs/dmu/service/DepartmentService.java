package dmucs.dmu.service;

import dmucs.dmu.member.Department;
import dmucs.dmu.member.Division;
import dmucs.dmu.repository.JpaDepartmentRepository;
import dmucs.dmu.repository.JpaDivisionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {
    final String DepartmentURL = "https://www.dongyang.ac.kr/sites/dongyang/intro/index.html";
    private final JpaDepartmentRepository jpaDepartmentRepository;
    private final JpaDivisionRepository jpaDivisionRepository;
    public void update () {
        jpaDepartmentRepository.deleteAll();
        jpaDivisionRepository.deleteAll();
        jpaDepartmentRepository.saveAll(getDepartment());
        jpaDivisionRepository.saveAll(getDivision());
    }
    public List<Division> getDivision () {
        try{
            Elements divTable = Jsoup.connect(DepartmentURL).get().select(".grid > .container > h2 > span");
            List<Division> divArr = new ArrayList<>();
            for(String a : divTable.text().split(" ")){
                divArr.add(new Division(a));
            }
            return divArr;
        } catch (IOException e) {
            log.trace(e.getMessage());
        }
        return null;
    }

    public List<Department> getDepartment (){
        try{
            List<Department> deptArr = new ArrayList<>();
            Elements deptTable = Jsoup.connect(DepartmentURL).get().select(".depart_list > ul");
            for(int i = 0; i < deptTable.size(); i++){
                for(int k = 0; k < deptTable.get(i).select("li").size(); k++){
                    deptArr.add(new Department(deptTable.get(i).select("li").select(".a").text()));
                }
            }
            return deptArr;
        } catch (IOException e) {
            log.trace(e.getMessage());
        }
        return null;
    }
}
