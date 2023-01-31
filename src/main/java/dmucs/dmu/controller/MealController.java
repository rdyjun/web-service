package dmucs.dmu.controller;

import dmucs.dmu.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @PostMapping("/meal")
    public ArrayList meal() {
        return mealService.getThisWeekMeal();
    }
}
