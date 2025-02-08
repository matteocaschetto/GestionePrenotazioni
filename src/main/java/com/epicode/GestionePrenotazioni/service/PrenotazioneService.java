package com.epicode.GestionePrenotazioni.service;
import com.epicode.GestionePrenotazioni.model.Postazione;
import com.epicode.GestionePrenotazioni.model.Prenotazione;
import com.epicode.GestionePrenotazioni.model.Utente;
import com.epicode.GestionePrenotazioni.repository.PrenotazioneDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAORepository prenotazioneRepository;
    public Prenotazione creaPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        if (prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, dataPrenotazione)) {
            throw new IllegalArgumentException("Esiste già una prenotazione per questa postazione in questa data.");
        }
        Prenotazione prenotazione = new Prenotazione(null, utente, postazione, dataPrenotazione);
        return prenotazioneRepository.save(prenotazione);
    }
}
