package com.api.daylog.domain.user.dto.response;

import com.api.daylog.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private long userId;

    private String name;

    public static UserResponse from(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getId());
        userResponse.setName(user.getName());
        return userResponse;
    }
}
