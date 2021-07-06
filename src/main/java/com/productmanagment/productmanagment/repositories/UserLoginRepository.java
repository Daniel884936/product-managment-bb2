package com.productmanagment.productmanagment.repositories;
import com.productmanagment.productmanagment.models.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    @Query(value = "select * from user_login ul where ul.username = ?1 and ul.password = ?2",
            nativeQuery = true)
    public UserLogin getLoginByCredentials(String username, String password);
}
