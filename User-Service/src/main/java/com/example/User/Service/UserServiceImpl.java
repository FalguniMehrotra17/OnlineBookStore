package com.example.User.Service;
//import com.example.User.Service.User;
//import com.example.User.Service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        // Implement registration logic
        // Typically involves saving the user entity
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUserProfile(String username, User updatedUser) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            // Update user details
            existingUser.setEmail(updatedUser.getEmail());
            // Update other fields as needed
            return userRepository.save(existingUser);
        }
        return null; // Handle case where user doesn't exist
    }

    @Override
    public void deleteUser(String username) {
        User userToDelete = userRepository.findByUsername(username);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        }
        // Handle case where user doesn't exist
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }
    
    // Implement other methods as needed
}

