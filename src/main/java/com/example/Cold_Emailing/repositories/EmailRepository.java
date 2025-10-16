package com.example.Cold_Emailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Cold_Emailing.entities.Email;

import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {
    Optional<Email> findByEmail(String email);

    boolean existsByEmail(String email);
}