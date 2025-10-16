package com.example.Cold_Emailing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Cold_Emailing.entities.EmailSent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmailSentRepository extends JpaRepository<EmailSent, Long> {
    List<EmailSent> findBySentAtBetween(LocalDateTime start, LocalDateTime end);

    Optional<EmailSent> findByEmail(String email);

    void deleteByEmailIn(List<String> emails);
}
