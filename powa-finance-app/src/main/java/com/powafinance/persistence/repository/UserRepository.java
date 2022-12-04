package com.powafinance.persistence.repository;

import com.powafinance.persistence.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u.id as id, u.username as userName, u.email, u.passhash as passHash from {h-schema}users u " +
            "where u.username = :username", nativeQuery = true)
    User findUserById(@Param("username") String username);

    @Query(value = "delete from {h-schema}users u where u.username = :usernameToDelete", nativeQuery = true)
    User deleteByUsername(@Param("usernameToDelete") String username);
}
