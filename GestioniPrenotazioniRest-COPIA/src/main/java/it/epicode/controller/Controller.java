package it.epicode.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.model.Citta;
import it.epicode.service.CittàService;


/*
 * 
Realizzare un endpoint informativo, che ritorni un testo contenente le regole di prenotazione. L'endpoint deve accettare una lingua tra Italiano ed inglese 
e deve ritornare il testo corretto. Il testo in entrambe le lingue deve essere configurabile.
Implementare un meccanismo che notifichi al cliente un errore nel caso venga richiesta una lingua non supportata dal sistema.
Realizzare una collection Postman e definire la chiamata per l'endpoint appena realizzato.

 */


@RestController
//@RequestMapping("/controller")
public class Controller {

	@Value("${gestioneprenotazioni.istruzioniInglese}")
	private String istruzioniInglese;
	
	@Value("${gestioneprenotazioni.istruzioniItaliano}")
	private String istruzioniItaliano;

	@GetMapping ("/regole")
	String leggiRegole (@RequestParam String lingua) {
		
		if(lingua.equalsIgnoreCase("en")) {
			return istruzioniInglese;
		} else if (lingua.equalsIgnoreCase("it")) {
			return istruzioniItaliano;
		} else {
			return "Lingua non supportata.";
		}
	}
}
		
	

