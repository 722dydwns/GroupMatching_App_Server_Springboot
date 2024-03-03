package dydwns.gmaSpringBootServer.dao;

import dydwns.gmaSpringBootServer.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Insert("INSERT INTO user_table(user_id, user_pw, user_nick_name) values(#{user_id}, #{user_pw}, #{user_nick_name})")
    int insertUser(@Param("user_id") String userId, @Param("user_pw") String userPw, @Param("user_nick_name") String userNickName);

    @Select("SELECT * FROM user_table WHERE user_id = #{id}")
    User selectUser(@Param("id") String userId);

}
