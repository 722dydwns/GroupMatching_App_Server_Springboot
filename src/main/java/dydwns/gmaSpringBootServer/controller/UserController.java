package dydwns.gmaSpringBootServer.controller;

import dydwns.gmaSpringBootServer.controller.vo.SignUpRequestVO;
import dydwns.gmaSpringBootServer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity signUpUser(@RequestBody SignUpRequestVO signUpRequestVO) {
        boolean success = userService.signUpUser(signUpRequestVO.getUserId(), signUpRequestVO.getUserPw(), signUpRequestVO.getUserNickName());
        if (success) {
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
