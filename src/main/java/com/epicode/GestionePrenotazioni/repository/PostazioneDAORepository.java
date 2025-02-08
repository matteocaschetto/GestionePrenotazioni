package com.epicode.GestionePrenotazioni.repository;

import com.epicode.GestionePrenotazioni.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDAORepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificioCitta(TipoPostazione tipo, String citta);
}

