package comuser.shop.jinproject.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class board {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createAt;
    private int views;
    private int level;
    private int notice;
    private User user;
}
