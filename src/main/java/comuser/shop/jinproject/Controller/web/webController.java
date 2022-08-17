package comuser.shop.jinproject.Controller.web;

import comuser.shop.jinproject.model.calenda.Day;
import comuser.shop.jinproject.model.calenda.Week;
import comuser.shop.jinproject.service.CalendarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class webController {

    @GetMapping({"","index.html"})
    public String MainPage(Model model, @RequestParam(required = false) Optional<Integer> year, @RequestParam(required = false) Optional<Integer> month){
        CalendarService calendarService = new CalendarService(year,month);
        List<Week> weekList = calendarService.getCalendar();
        model.addAttribute("WeekList" , calendarService.getCalendar());
        model.addAttribute("Year",calendarService.getYear());
        model.addAttribute("Month",calendarService.getMonth());
        return "index";
    }

}
