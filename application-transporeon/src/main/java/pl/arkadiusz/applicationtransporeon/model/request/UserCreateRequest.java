package pl.arkadiusz.applicationtransporeon.model.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private final String username;
    private final String password;
}
