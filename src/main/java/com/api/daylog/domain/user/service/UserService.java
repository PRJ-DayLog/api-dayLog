package com.api.daylog.domain.user.service;

import com.api.daylog.domain.user.dto.request.UserCreateRequest;
import com.api.daylog.domain.user.dto.response.UserResponse;
import com.api.daylog.domain.user.repository.UserRepository;
import com.api.daylog.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        User createUser = User.from(userCreateRequest);
        createUser = userRepository.save(createUser);
        return UserResponse.from(createUser);
    }
}