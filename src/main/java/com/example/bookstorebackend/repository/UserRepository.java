package com.example.bookstorebackend.repository;
import com.example.bookstorebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
    User getUserById(Long id);
    void deleteById(Long id);
}
