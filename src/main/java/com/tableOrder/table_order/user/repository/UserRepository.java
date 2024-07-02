package com.tableOrder.table_order.user.repository;

import com.tableOrder.table_order.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {


    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

}
