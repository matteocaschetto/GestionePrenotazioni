package com.epicode.GestionePrenotazioni.configuration;

import com.epicode.GestionePrenotazioni.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    @Bean(name = "edificio1")
    public Edificio edificio1() {
        return new Edificio(null,"Torre A", "Via Roma 10", "Milano");
    }


    @Bean(name = "postazione1")
    public Postazione postazione1() {
        return new Postazione(null,"P001", "Ufficio privato con vista", TipoPostazione.PRIVATO, 2, edificio1());
    }



    @Bean(name = "utente1")
    public Utente utente1() {
        return new Utente(null,"m.rossi", "Mario Rossi", "mario.rossi@email.com");
    }



    @Bean(name = "prenotazione1")
    @Scope("prototype")
    public Prenotazione prenotazione1() {
        return new Prenotazione(null,utente1(), postazione1(), LocalDate.now().plusDays(1));
    }


}

