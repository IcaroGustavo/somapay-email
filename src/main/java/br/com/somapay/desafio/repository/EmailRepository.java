package br.com.somapay.desafio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.somapay.desafio.model.Email;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
