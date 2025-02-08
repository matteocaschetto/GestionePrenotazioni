package com.epicode.GestionePrenotazioni.service;
import com.epicode.GestionePrenotazioni.model.Edificio;
import com.epicode.GestionePrenotazioni.repository.EdificioDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EdificioService {
    @Autowired
    private EdificioDAORepository edificioRepository;
    public Edificio creaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }
    public Edificio findByNome(Long id) {
        return edificioRepository.findById(id).orElse(null);
    }
}