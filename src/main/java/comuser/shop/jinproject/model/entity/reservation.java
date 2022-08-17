package comuser.shop.jinproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class reservation {
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int status;
    private User user;
}
