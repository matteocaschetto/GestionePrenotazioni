package com.epicode.GestionePrenotazioni.repository;

import com.epicode.GestionePrenotazioni.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioDAORepository extends JpaRepository<Edificio, Long> {
    Edificio findByNome(String nome);
}

