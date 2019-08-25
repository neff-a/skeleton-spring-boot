package com.nalar.app.repository;

import com.nalar.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findOneByEmailAndStatus(final String email, final String status);

    User findOneByUuid(final String uuid);

}
