package com.api.daylog.domain.user.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotEmpty
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}")
    private String phoneNumber;

    @NotEmpty
    private String name;

    @NotEmpty
    @Length(min = 8, max = 15)
    private String password;
}
