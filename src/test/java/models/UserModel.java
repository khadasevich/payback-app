package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

    private String cardNumber;
    private String password;
}
