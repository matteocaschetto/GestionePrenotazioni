package com.epicode.GestionePrenotazioni.repository;
import com.epicode.GestionePrenotazioni.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long> {
    Utente findByNomeCompleto(String nomeCompleto);
}