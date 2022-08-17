package comuser.shop.jinproject.model.calenda;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {
    private String title;
    private String content;

    public Job(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
