package com.example.springmvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Calendar;

@Controller
public class YoilController {
    @RequestMapping("/getYoil")
    public static String main(int year, int month, int day, Model model) {
        if(!isValid(year, month, day)) return "yoilError";
        char yoil = getYoil(year, month, day);

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        return "yoil";
    }

    private static char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return "일월화수목금토".charAt(dayOfWeek);
    }

    private static boolean isValid(int year, int month, int day) {
        return true;
    }
}