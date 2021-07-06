package com.productmanagment.productmanagment.repositories;

import com.productmanagment.productmanagment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user u inner join user_login ul on u.user_id = ul.user_id " +
            "where ul.username = ?1", nativeQuery = true)
    public User findUserByUserName(String userName);
}
