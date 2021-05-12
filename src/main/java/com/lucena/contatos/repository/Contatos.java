package com.lucena.contatos.repository;

import com.lucena.contatos.model.Contato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Contatos extends JpaRepository<Contato, Long> {

}