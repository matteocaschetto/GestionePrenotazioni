package com.epicode.GestionePrenotazioni.service;


import com.epicode.GestionePrenotazioni.model.Edificio;
import com.epicode.GestionePrenotazioni.model.Postazione;
import com.epicode.GestionePrenotazioni.model.TipoPostazione;
import com.epicode.GestionePrenotazioni.repository.EdificioDAORepository;
import com.epicode.GestionePrenotazioni.repository.PostazioneDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneDAORepository postazioneRepository;

    @Autowired
    private EdificioDAORepository edificioRepository;


    public Postazione creaPostazione(Postazione postazione) {
        Edificio edificio = postazione.getEdificio();
        if (edificio.getId() == null) {
            edificio = edificioRepository.save(edificio);
            postazione.setEdificio(edificio);
        }
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> ricercaPostazioni(String tipo, String citta) {
        TipoPostazione tipoPostazione = TipoPostazione.valueOf(tipo);
        return postazioneRepository.findByTipoAndEdificioCitta(tipoPostazione, citta);
    }
}
