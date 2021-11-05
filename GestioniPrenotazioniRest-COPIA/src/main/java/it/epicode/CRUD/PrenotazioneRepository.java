package it.epicode.CRUD;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.model.Citta;
import it.epicode.model.Edificio;
import it.epicode.model.Postazione;
import it.epicode.model.Prenotazione;
import it.epicode.model.TipoPostazione;



public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	
	
	 /*
     * -Una prenotazione vale per un solo giorno e puà essere effettuata solo se 
     * per quel giorno la postazione risulta libera.
     */
	
	@Query("SELECT u FROM Prenotazione u WHERE u.postazione.id = :postazioneId  AND u.dataPrenotata = :data" )
	List<Prenotazione> findByPostazioneEData(Long postazioneId, LocalDate data);
	
	@Query("SELECT u FROM Prenotazione u WHERE u.postazione.id = :postazioneId" )
	List<Prenotazione> findByPostazione(Long postazioneId);
	
	@Query("SELECT u FROM Prenotazione u WHERE u.dataPrenotata = :data" )
	List<Prenotazione> findByData(LocalDate data);

	/*
	 * /*
 * -Un utente può avere più prenotazioni in corso, 
 * ma non può prenotare più di una postazione per una particolare data.
	 */
	@Query("SELECT u FROM Prenotazione u WHERE u.user.id = :id  AND u.dataPrenotata = :data" )
	List<Prenotazione> findByUtenteEData(Long id, LocalDate data);
	
    Page<Prenotazione> findAll (Pageable pageable);

	
	//formula: findBy + OrderBy + NomeColonna + Ordinamento
	List<Prenotazione> findByOrderByDataPrenotataDesc();

	
	
}


