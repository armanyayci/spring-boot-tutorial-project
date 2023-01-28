package dtos;
import lombok.Data;
import validator.UniqueUserName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class UserCreateDTO {

    @Size(min = 4,max = 24, message = "tutorial2.constraints.UniqueUserName.message")
    @NotNull(message = "{tutorial2.constraints.name.NotNull.message}")
    @UniqueUserName
    private String userName;
    @Size(min = 2, max = 32, message = "{tutorial2.constraints.name.Size.message}")
    @NotNull(message = "{tutorial2.constraints.name.NotNull.message}")
    private String name;
    @Size(min = 3, max = 32, message = "{tutorial2.constraints.surname.Size.message}")
    @NotNull(message = "{tutorial2.constraints.surname.NotNull.message}")
    private String surname;
    @Size(min = 6, max = 32, message = "{tutorial2.constraints.password.Size.message}")
    @NotNull(message = "{tutorial2.constraints.password.NotNull.message}")
    private String password;

}
