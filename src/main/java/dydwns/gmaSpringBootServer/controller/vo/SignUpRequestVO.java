package dydwns.gmaSpringBootServer.controller.vo;

import lombok.Data;

@Data
public class SignUpRequestVO {
    private String userId;
    private String userPw;
    private String userNickName;
}
