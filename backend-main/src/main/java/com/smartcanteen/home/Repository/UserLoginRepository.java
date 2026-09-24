package com.smartcanteen.home.Repository;

import com.smartcanteen.home.Entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    Optional<UserLogin> findByEmail(String email);
}
