package com.example.bookstorebackend.repository;
import com.example.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
    Optional<User> findByUsername(String username);
    User getUserById(Long id);
    void deleteById(Long id);
    List<User> getAllByRole(Integer role);
}
