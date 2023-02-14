package dmucs.dmu.controller;

import dmucs.dmu.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;

    @PostMapping("/meal")
    public String[][] meal() {
        return mealService.getThisWeekMeal();
    }
}
