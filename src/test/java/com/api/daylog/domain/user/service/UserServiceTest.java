package com.api.daylog.domain.user.service;

import com.api.daylog.domain.user.dto.request.UserCreateRequest;
import com.api.daylog.domain.user.dto.response.UserResponse;
import com.api.daylog.domain.user.repository.UserRepository;
import com.api.daylog.entity.User;
import com.api.daylog.helper.UnitTestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;

class UserServiceTest extends UnitTestHelper {

    @InjectMocks private UserService userService;

    @Mock private UserRepository userRepository;

    @Test
    @DisplayName("회원 생성하는 서비스 테스트")
    void createUser () throws Exception {
        // given
        UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                .name("범수")
                .phoneNumber("010-1234-1234")
                .password("12341234")
                .build();

        User createUser = User.from(userCreateRequest);
        createUser.setId(11L);

        when(userRepository.save(any(User.class)))
                .thenReturn(createUser);

        // when
        UserResponse userResponse = userService.createUser(userCreateRequest);

        // then
        assertThat(userResponse.getName()).isEqualTo("범수");
    }
}