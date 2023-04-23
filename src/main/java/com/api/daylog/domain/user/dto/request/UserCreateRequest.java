package com.api.daylog.domain.user.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    @Length(min = 8, max = 15)
    private String password;
}
