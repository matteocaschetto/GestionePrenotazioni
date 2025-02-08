package com.epicode.GestionePrenotazioni.runner;
import com.epicode.GestionePrenotazioni.model.*;
import com.epicode.GestionePrenotazioni.service.EdificioService;
import com.epicode.GestionePrenotazioni.service.PrenotazioneService;
import com.epicode.GestionePrenotazioni.service.PostazioneService;
import com.epicode.GestionePrenotazioni.service.UtenteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
@Component
@Transactional
public class PrenotazioneRunner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    @Lazy
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Override
    public void run(String... args) throws Exception {
        // Creazione di edifici
        Edificio edificio1 = edificioService.creaEdificio(new Edificio(null, "Torre A", "Via Roma 10", "Milano"));
        Edificio edificio2 = edificioService.creaEdificio(new Edificio(null, "Torre B", "Via Modica 20", "Ragusa"));
        Edificio edificio3 = edificioService.creaEdificio(new Edificio(null, "Torre C", "Via Torino 15", "Torino"));
        Edificio edificio4 = edificioService.creaEdificio(new Edificio(null, "Torre D", "Via Napoli 30", "Napoli"));
// Creazione di postazioni
        Postazione postazione1 = postazioneService.creaPostazione(new Postazione(null, "P001", "Ufficio Privato", TipoPostazione.PRIVATO, 2, edificio1));
        Postazione postazione2 = postazioneService.creaPostazione(new Postazione(null, "P002", "Sala Riunioni", TipoPostazione.SALA_RIUNIONI, 50, edificio2));
        Postazione postazione3 = postazioneService.creaPostazione(new Postazione(null, "P003", "Open Space", TipoPostazione.OPENSPACE, 10, edificio3));
        Postazione postazione4 = postazioneService.creaPostazione(new Postazione(null, "P004", "Ufficio Privato", TipoPostazione.PRIVATO, 1, edificio4));
// Creazione di utenti
        Utente utente1 = utenteService.findByNomeCompleto("Alex Del Piero");
        if (utente1 == null) {
            utente1 = utenteService.creaUtente(new Utente(null, "pinturicchio", "Alex Del Piero", "alex.delpiero@email.com"));
        }
        Utente utente2 = utenteService.findByNomeCompleto("Matteo Caschetto");
        if (utente2 == null) {
            utente2 = utenteService.creaUtente(new Utente(null, "m.caschetto", "Matteo Caschetto", "matteo.caschetto@email.com"));
        }
        Utente utente3 = utenteService.findByNomeCompleto("Francesca Rossi");
        if (utente3 == null) {
            utente3 = utenteService.creaUtente(new Utente(null, "f.rossi", "Francesca Rossi", "francesca.rossi@email.com"));
        }
        Utente utente4 = utenteService.findByNomeCompleto("Luca Bianchi");
        if (utente4 == null) {
            utente4 = utenteService.creaUtente(new Utente(null, "l.bianchi", "Luca Bianchi", "luca.bianchi@email.com"));
        }
        LocalDate dataPrenotazione = LocalDate.now().plusDays(1);
// Creazione di prenotazioni
        try {
            prenotazioneService.creaPrenotazione(utente1, postazione1, dataPrenotazione);
            System.out.println("Prenotazione effettuata con successo!");
        } catch (Exception e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
        try {
            prenotazioneService.creaPrenotazione(utente2, postazione2, dataPrenotazione);
            System.out.println("Prenotazione effettuata con successo!");
        } catch (Exception e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
        try {
            prenotazioneService.creaPrenotazione(utente3, postazione3, dataPrenotazione);
            System.out.println("Prenotazione effettuata con successo!");
        } catch (Exception e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
        try {
            prenotazioneService.creaPrenotazione(utente4, postazione4, dataPrenotazione);
            System.out.println("Prenotazione effettuata con successo!");
        } catch (Exception e) {
            System.err.println("Errore durante la prenotazione: " + e.getMessage());
        }
// Ricerca postazioni disponibili
        List<Postazione> postazioniDisponibili = postazioneService.ricercaPostazioni(TipoPostazione.PRIVATO.toString(), "Milano");
        System.out.println("Postazioni disponibili a Milano: " + postazioniDisponibili.size());
    }
}