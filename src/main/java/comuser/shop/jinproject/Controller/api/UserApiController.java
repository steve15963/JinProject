package comuser.shop.jinproject.Controller.api;

import comuser.shop.jinproject.inter.CRUDInterFace;
import comuser.shop.jinproject.model.entity.User;
import comuser.shop.jinproject.model.network.Header;
import comuser.shop.jinproject.model.network.request.UserApiRequest;
import comuser.shop.jinproject.model.network.response.UserApiResponse;
import comuser.shop.jinproject.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CRUDInterFace<UserApiRequest,UserApiResponse> {

    @Autowired
    private UserApiService userApiService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        return userApiService.create(request);
    }

    @Override
    @GetMapping("/id/{id}")
    public Header<UserApiResponse> read(@PathVariable int id) {
        return userApiService.read(id);
    }

    @GetMapping("/account/{account}")
    public Header<UserApiResponse> read(@PathVariable String account) {
        return userApiService.read(account);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiService.update(request);
    }

    @Override
    public Header<UserApiResponse> delete(int id) {
        return userApiService.delete(id);
    }

}
