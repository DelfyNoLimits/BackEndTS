package com.upc.edu.BackEndTripStore.repository;

import com.upc.edu.BackEndTripStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByUsernameAndPassword(String username, String password);
}
