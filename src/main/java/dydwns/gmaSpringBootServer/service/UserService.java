package dydwns.gmaSpringBootServer.service;

import dydwns.gmaSpringBootServer.dao.UserDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserDao userDao;

    public boolean signUpUser(String userId, String userPw, String userNickName){
        try {
            userDao.insertUser(userId, userPw, userNickName);
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
    }
}
