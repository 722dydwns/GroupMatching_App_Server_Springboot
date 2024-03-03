package dydwns.gmaSpringBootServer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class User {
    private Long userIdx;
    private String userId;
    private String userPw;
    private String userNickName;
}
