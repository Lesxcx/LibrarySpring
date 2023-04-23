package com.konrad_szydlowski.demo.user.service;

import com.konrad_szydlowski.demo.user.exception.UserException;
import com.konrad_szydlowski.demo.user.model.UserDto;
import com.konrad_szydlowski.demo.user.repository.UserRepository;
import com.konrad_szydlowski.demo.user.repository.table.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    final UserRepository userRepository;

    public UserDto findUserById(final Long id) {
        final User userById = userRepository.findById(id).stream().filter(user -> Objects.equals(user.getId(), id))
                .findFirst().orElseThrow(() -> new UserException("There is no user of that id: " + id));

        return new UserDto(userById.getFirstName(), userById.getLastName());
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Map<String, Boolean> deleteUserById(final Long userId) throws UserException {

        final User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found on: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }
}
