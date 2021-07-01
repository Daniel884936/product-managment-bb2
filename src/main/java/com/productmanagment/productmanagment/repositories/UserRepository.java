package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
