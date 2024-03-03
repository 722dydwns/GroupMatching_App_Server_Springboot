package dydwns.gmaSpringBootServer.controller;

import dydwns.gmaSpringBootServer.controller.vo.LoginRequestVO;
import dydwns.gmaSpringBootServer.controller.vo.LoginResponseVO;
import dydwns.gmaSpringBootServer.controller.vo.SignUpRequestVO;
import dydwns.gmaSpringBootServer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseVO> login(@RequestBody LoginRequestVO loginRequestVO) {
        boolean success = userService.loginUser(loginRequestVO.getUserId(), loginRequestVO.getUserPw());

        if(success){
            return ResponseEntity.ok(LoginResponseVO.builder()
                    .message("로그인 성공")
                    .build());
        }else{
            return ResponseEntity.badRequest()
                    .body(LoginResponseVO.builder()
                            .message("로그인 실패")
                            .build());
        }
    }

}
