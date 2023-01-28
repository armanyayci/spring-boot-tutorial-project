package api;

import Business.UserService;
import dtos.UserCreateDTO;
import dtos.UserUpdateDTO;
import dtos.UserViewDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shared.GenericResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("v1/{id}")
    public ResponseEntity<UserViewDTO> getUser(@PathVariable int id)
    {
        UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v2/users")
    public ResponseEntity<List<UserViewDTO>> getAllUsers()
    {
        List<UserViewDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("v2")
    public ResponseEntity<GenericResponse> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO)
    {
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("user created"));
    }

    @PutMapping("v2/update/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") int id, @RequestBody UserUpdateDTO userUpdateDTO )
    {
        UserViewDTO user = userService.updateUser(id, userUpdateDTO);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("v2/delete/{id}")
    public ResponseEntity<GenericResponse> deleteUser(@PathVariable("id") int id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User Deleted"));
    }


    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable)
    {
        List<UserViewDTO> users = userService.slice(pageable);
        return ResponseEntity.ok(users);
    }
    


}
