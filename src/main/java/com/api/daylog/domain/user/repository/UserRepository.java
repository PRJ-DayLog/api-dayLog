package com.api.daylog.domain.user.repository;

import com.api.daylog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
