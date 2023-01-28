package Business;
import dtos.UserCreateDTO;
import dtos.UserUpdateDTO;
import dtos.UserViewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService{

    UserViewDTO getUserById(int id);

    List<UserViewDTO> getUsers();
    UserViewDTO createUser(UserCreateDTO user);
    UserViewDTO updateUser(int id, UserUpdateDTO userUpdateDTO);
    void deleteUser(int id);
    List<UserViewDTO> slice(Pageable pageable);
}
