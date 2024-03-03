package dydwns.gmaSpringBootServer.controller.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseVO {
    String message;
    Long userIdx;
}
