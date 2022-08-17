package comuser.shop.jinproject.model.calenda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Week {
    private List<Day> dayList = new ArrayList<>();
    public void addDay(Day day){
        dayList.add(day);
    }
    public Day getjob(){
        return dayList.remove(0);
    }
}
