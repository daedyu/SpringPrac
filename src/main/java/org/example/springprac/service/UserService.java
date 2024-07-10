package org.example.springprac.service;

import lombok.RequiredArgsConstructor;
import org.example.springprac.model.User;
import org.example.springprac.repository.UserRepository;
import org.example.springprac.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User registerUser(UserRequest user) {
        if (getUser(user.getUsername()) != null) throw new RuntimeException();
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return saveUser(user1);
    }

    public User loginUser(UserRequest user) {
        User user1 = getUser(user.getUsername());
        if (user1 == null) throw new RuntimeException();
        if (user1.getPassword().equals(user.getPassword())) throw new RuntimeException();

    }
}
