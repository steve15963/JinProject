package comuser.shop.jinproject.service;

import comuser.shop.jinproject.model.calenda.Day;
import comuser.shop.jinproject.model.calenda.Job;
import comuser.shop.jinproject.model.calenda.Week;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class CalendarService {

    Calendar calendar;
    int year;
    int month;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public CalendarService(Optional<Integer> year, Optional<Integer> month ) {
        calendar = Calendar.getInstance();

        if(year.isEmpty())this.year = LocalDateTime.now().getYear();
        else this.year = year.get().intValue();
        if(month.isEmpty()) this.month = LocalDateTime.now().getMonthValue();
        else this.month = month.get().intValue();

        calendar.set(this.year,this.month-1,1);
    }
    public List<Week> getCalendar(){
        List<Week> weekList = new ArrayList<>();
        int end = calendar.getActualMaximum(Calendar.DATE);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int i,k;
        weekList.add(new Week());
        for (i = 1; i < dayOfWeek; i++) {
            Day day = new Day("");
            day.addjob(new Job("",""));
            weekList.get(0).addDay(day);
        }
        k=(i+1-dayOfWeek);
        System.out.println("end = " + end);
        for (; i <= 7; i++) {
            Day day = new Day(""+k);
            day.addjob(new Job("",""));
            weekList.get(0).addDay(day);
            k++;
        }
        for(i = 1;i<6;i++){
            weekList.add(new Week());
            for(int j = 0;j<7;j++){
                if(k<=end) {
                    Day day = new Day("" + k);
                    day.addjob(new Job("", ""));
                    weekList.get(i).addDay(day);
                    k++;
                }
                else break;
            }
        }
        return weekList;
    }

}
