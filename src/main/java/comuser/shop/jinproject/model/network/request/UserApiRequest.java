package comuser.shop.jinproject.model.network.request;

import comuser.shop.jinproject.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiRequest {
    private int id;
    private String account;
    private String password;
    private int level;
    private int status;
}
