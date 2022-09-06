package com.kan.myworkout.repository;

import com.kan.myworkout.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {

    Page<User> findByUsernameContaining(String searchName, Pageable pageable);
}
