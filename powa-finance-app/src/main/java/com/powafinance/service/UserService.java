package com.powafinance.service;

import com.powafinance.dto.UserDto;
import com.powafinance.dto.Usernames;
import com.powafinance.persistence.repository.UserRepository;
import com.powafinance.persistence.table.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    /**
     * 1. When data is persisted with @Cacheable, it will be cached even for first GET
     * 2. When data is deleted, but no @CacheEvict provided - still in cache
     */

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Cacheable(cacheNames = "powaFinanceUsers", key = "#userDto.userName")
    public void persistUserData(final UserDto userDto) {
        final User entity = modelMapper.map(userDto, User.class);
        userRepository.save(entity);
    }

    @Cacheable(value = "powaFinanceUsers")
    public User retrieveUserData(String username) {
        return userRepository.findUserById(username);
    }

    @CachePut(cacheNames = "powaFinanceUsers")
    @Transactional
    public void updateCache(final Usernames usernames) {
        userRepository.updateUser(usernames.getOldName(), usernames.getNewName());
    }

    @CacheEvict(cacheNames = "powaFinanceUsers")
    @Transactional
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    public List<User> retrieveAllUsers() {
        return userRepository.findAllUsers();
    }

}
