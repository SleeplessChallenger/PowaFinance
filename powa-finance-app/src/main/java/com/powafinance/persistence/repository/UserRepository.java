package com.powafinance.persistence.repository;

import com.powafinance.persistence.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value =
            "select u.id as id, u.username as userName, u.email, u.passhash as passHash from {h-schema}users u " +
                    "where u.username = :username", nativeQuery = true)
    User findUserById(@Param("username") String username);

    @Modifying
    @Query(value = "DELETE from {h-schema}users WHERE username = :usernameToDelete", nativeQuery = true)
    void deleteByUsername(@Param("usernameToDelete") String username);

    @Query(value = "select u.id, u.username as userName, u.email, u.passhash as passHash from {h-schema}users u",
            nativeQuery = true)
    List<User> findAllUsers();

    @Modifying
    @Query(value = "UPDATE {h-schema}users SET username = :newUserName WHERE username = :oldUserName",
            nativeQuery = true)
    void updateUser(@Param("oldUserName") String oldUserName, @Param("newUserName") String newUserName);
}
