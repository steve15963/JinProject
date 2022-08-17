package comuser.shop.jinproject.repository.ibatisMapper;

import comuser.shop.jinproject.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Optional;
import java.util.OptionalInt;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(id,account,password,level,status) VALUES(NULL,#{user.account},#{user.password},#{user.level},#{user.status});")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int save(@Param("user")User user);

    @Select("select * from user where id = #{id}")
    public Optional<User> findById(int id);

    @Select("select * from user where account = #{account}")
    public Optional<User> findByAccount(String account);

    @Update("update user SET password=#{user.password},level=#{user.level},status=#{user.status} where id=#{user.id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int update(@Param("user")User user);

    @Delete("Delete from user where id = #{id}")
    public int delete(@Param("id")int id);

}
