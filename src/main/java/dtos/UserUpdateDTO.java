package dtos;

import lombok.Data;

@Data
public class UserUpdateDTO {

    private String name;
    private String surname;
    private String password;

}
