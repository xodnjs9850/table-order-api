package com.tableOrder.table_order.user.repository;

import com.tableOrder.table_order.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT COUNT(u) > 0 FROM UserEntity u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

}
