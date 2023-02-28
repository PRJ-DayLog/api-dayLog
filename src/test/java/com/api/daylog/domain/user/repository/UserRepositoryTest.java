package com.api.daylog.domain.user.repository;

import com.api.daylog.common.enums.UserRole;
import com.api.daylog.domain.user.dto.request.UserCreateRequest;
import com.api.daylog.entity.User;
import com.api.daylog.helper.RepositoryTestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserRepositoryTest extends RepositoryTestHelper {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원 생성 레포지토리 테스트")
    void createUser () throws Exception {
        // given
        UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                .name("범수")
                .phoneNumber("010-1234-1234")
                .password("12341234")
                .build();
        // when
        User createUser = userRepository.save(User.from(userCreateRequest));
        // then
        assertThat(createUser.getName()).isEqualTo("범수");
        assertThat(createUser.getPhoneNumber()).isEqualTo("010-1234-1234");
        assertThat(createUser.getPassword()).isEqualTo("12341234");
        assertThat(createUser.getUserRole()).isEqualTo(UserRole.USER);
    }
}