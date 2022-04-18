package com.workspace.account.api.members.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "인증 요청시")
@Data
public class LoginRequest {

    @Schema(description = "oauth2 인증토큰")
    private String tokenId;
    @Schema(description = "사용자 명")
    private String name;
    @Schema(description = "사용자 이메일")
    private String email;
}
