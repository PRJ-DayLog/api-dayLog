package com.api.daylog.entity;

import com.api.daylog.common.entity.BaseDateWithDeletedEntity;
import com.api.daylog.common.enums.UserRole;
import com.api.daylog.domain.user.dto.request.UserCreateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseDateWithDeletedEntity {

    @Id
    @Setter
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    public static User from(UserCreateRequest userCreateRequest) {
        User createUser = new User();
        createUser.name = userCreateRequest.getName();
        createUser.email = userCreateRequest.getEmail();
        createUser.password = userCreateRequest.getPassword();
        createUser.userRole = UserRole.USER;
        return createUser;
    }
}
