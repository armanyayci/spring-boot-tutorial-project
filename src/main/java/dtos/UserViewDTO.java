package dtos;

import Repository.UserRepository;
import entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public final class UserViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String Surname;

    public static UserViewDTO of(User user)
    {
        return new UserViewDTO(user.getName(), user.getSurname());
    }

}
