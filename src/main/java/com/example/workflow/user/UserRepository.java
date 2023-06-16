package com.example.workflow.user;

import com.example.workflow.user.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
}
