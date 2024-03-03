package dydwns.gmaSpringBootServer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
//    @Insert("INSERT INTO user_table values(#{user_idx}, #{user_id}, #{user_pw}, #{user_nick_name})")
//    int insertUser(@Param("user_idx") Long userIdx, @Param("user_id") String userId, @Param("user_pw") String userPw, @Param("user_nick_name") String userNickName);

    @Insert("INSERT INTO user_table(user_id, user_pw, user_nick_name) values(#{user_id}, #{user_pw}, #{user_nick_name})")
    int insertUser(@Param("user_id") String userId, @Param("user_pw") String userPw, @Param("user_nick_name") String userNickName);

}
