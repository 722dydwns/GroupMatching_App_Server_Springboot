package dydwns.gmaSpringBootServer.service;

import dydwns.gmaSpringBootServer.dao.UserDao;
import dydwns.gmaSpringBootServer.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserDao userDao;

    //회원가입
    public boolean signUpUser(String userId, String userPw, String userNickName){
        try {
            userDao.insertUser(userId, userPw, userNickName);
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
    }

    //로그인
    public Long loginUser(String userId, String userPw){
        User user = userDao.selectUser(userId);

        if(user == null) {
            return null;
        }

        if(user.getUserPw().equals(userPw)){
            return user.getUserIdx();
        }

        return null;
    }
}
