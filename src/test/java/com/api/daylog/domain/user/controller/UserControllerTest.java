package com.api.daylog.domain.user.controller;

import com.api.daylog.domain.user.dto.request.UserCreateRequest;
import com.api.daylog.domain.user.dto.response.UserResponse;
import com.api.daylog.domain.user.service.UserService;
import com.api.daylog.helper.IntegrationTestHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest({UserController.class})
class UserControllerTest extends IntegrationTestHelper {

    @MockBean private UserService userService;

    @Test
    @DisplayName("회원 가입 API 테스트")
    void createUser() throws Exception {

        // given
        UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                .name("범수")
                .email("qhrud0527@naver.com")
                .password("12341234")
                .build();

        UserResponse userResponse = UserResponse.builder()
                .name("범수")
                .build();

        given(userService.createUser(any(UserCreateRequest.class)))
                .willReturn(userResponse);

        String content = objectMapper.writeValueAsString(userCreateRequest);

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/api/v1.0/user")
                .content(content)
                .contentType(APPLICATION_JSON)
        );
        // then

        resultActions.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.header.code").value(200))
                .andExpect(jsonPath("$.header.message").value("SUCCESS"))
                .andExpect(jsonPath("$.data.name").value("범수"));
    }
}