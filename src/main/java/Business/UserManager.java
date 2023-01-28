package Business;

import Repository.UserRepository;
import dtos.UserCreateDTO;
import dtos.UserUpdateDTO;
import dtos.UserViewDTO;
import entities.User;
import exception.notFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new notFoundException("Not Found"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers()
    {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userRepository.save
                (new User(userCreateDTO.getName(),userCreateDTO.getSurname(),userCreateDTO.getPassword()));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(int id, UserUpdateDTO userUpdateDTO) {

        User user = userRepository.findById(id).orElseThrow(()-> new notFoundException("invalid id"));
        user.setName(userUpdateDTO.getName());
        user.setSurname(userUpdateDTO.getSurname());
        user.setPassword(userUpdateDTO.getPassword());

        final User updatedUser = userRepository.save(user);
        return UserViewDTO.of(updatedUser);

    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(()-> new notFoundException("invalid"));
        userRepository.deleteById(id);

    }
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
    }


}