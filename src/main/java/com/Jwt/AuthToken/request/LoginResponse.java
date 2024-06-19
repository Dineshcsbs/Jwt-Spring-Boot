package com.Jwt.AuthToken.request;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LoginResponse {
    private String token;

    private Long expiresIn;

    public String getToken() {
        return token;
    }

}