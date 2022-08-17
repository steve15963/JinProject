package comuser.shop.jinproject.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiResponse {
    private int id;
    private String account;
    private String password;
    private int level;
    private int status;
}
