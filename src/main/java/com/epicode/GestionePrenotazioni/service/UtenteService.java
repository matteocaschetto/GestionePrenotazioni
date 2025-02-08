package com.epicode.GestionePrenotazioni.service;

import com.epicode.GestionePrenotazioni.model.*;

import com.epicode.GestionePrenotazioni.repository.UtenteDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UtenteService {

    @Autowired
    private UtenteDAORepository utenteRepository;



    public Utente creaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Utente findByNomeCompleto(String nomeCompleto) {
        return utenteRepository.findByNomeCompleto(nomeCompleto);
    }
}
