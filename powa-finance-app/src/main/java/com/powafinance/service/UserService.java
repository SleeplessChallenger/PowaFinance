package com.powafinance.service;

import com.powafinance.dto.UserDto;
import com.powafinance.persistence.repository.UserRepository;
import com.powafinance.persistence.table.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public void persistUserData(final UserDto userDto) {
        final User entity = modelMapper.map(userDto, User.class);
        userRepository.save(entity);
    }

    public User retrieveUserData(String username) {
        return userRepository.findUserById(username);
    }
}
