package comuser.shop.jinproject.service;

import comuser.shop.jinproject.inter.CRUDInterFace;
import comuser.shop.jinproject.model.entity.User;
import comuser.shop.jinproject.model.network.Header;
import comuser.shop.jinproject.model.network.request.UserApiRequest;
import comuser.shop.jinproject.model.network.response.UserApiResponse;
import comuser.shop.jinproject.repository.ibatisMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserApiService implements CRUDInterFace<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest apiRequest = request.getData();
        if(userMapper.findByAccount(apiRequest.getAccount()).isEmpty()) {
            User user = User.builder()
                    .account(apiRequest.getAccount())
                    .password(apiRequest.getPassword())
                    .level(4)
                    .status(0)
                    .build();
            int save = userMapper.save(user);
            if (save != 1) {
                //Logger 로그 배울것
                return Header.ERROR("저장에 실패했습니다.");
            }
            return response(user);
        }
        return Header.ERROR("계정명 중복");
    }

    @Override
    public Header<UserApiResponse> read(int id) {
        return userMapper.findById(id)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("해당 id를 가진 회원을 찾을 수 없습니다."));
    }
    public Header<UserApiResponse> read(String account) {
        return userMapper.findByAccount(account)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("해당 account를 가진 회원을 찾을 수 없습니다."));
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest apiRequest = request.getData();
        User user = User.builder()
                .id(apiRequest.getId())
                .account(apiRequest.getAccount())
                .password(apiRequest.getPassword())
                .level(apiRequest.getLevel())
                .status(apiRequest.getStatus())
                .build();
        int count = userMapper.update(user);
        if( count < 1)
            return Header.ERROR("중복 업데이트 대상자 발생");
        else if(count > 1 )
            return Header.ERROR("업데이트 실패");
        return response(user);
    }

    @Override
    public Header<UserApiResponse> delete(int id) {
        int count = userMapper.delete(id);
        if(count < 1)
            return Header.ERROR("해당 id를 가진 계정이 없습니다.");
        else if( count == 1)
            return Header.OK();
        return Header.ERROR("해당 id를 가진 계정이 많습니다.");
    }

    private Header<UserApiResponse> response(User user){
        UserApiResponse userApiResponse = UserApiResponse
                .builder()
                .id(user.getId())
                .password(user.getPassword())
                .level(user.getLevel())
                .status(user.getStatus())
                .build();
        return Header.OK(userApiResponse);
    }
}
