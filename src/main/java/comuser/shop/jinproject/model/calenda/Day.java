package comuser.shop.jinproject.model.calenda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Day {
    private String day;

    public Day(String day) {
        this.day = day;
    }

    List<Job> jobList = new ArrayList<>();

    public void addjob(Job job){
        jobList.add(job);
    }
    public Job getjob(){
        return jobList.remove(0);
    }
}
