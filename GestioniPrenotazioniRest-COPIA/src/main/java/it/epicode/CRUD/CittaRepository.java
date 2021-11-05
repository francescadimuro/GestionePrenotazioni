package it.epicode.CRUD;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.model.Citta;
import it.epicode.model.Prenotazione;
import it.epicode.model.User;



public interface CittaRepository extends JpaRepository<Citta, Long> {


	@Query("SELECT u FROM Citta u WHERE u.nome = :nome" )
	List<Citta> findbyName(String nome);
	
	Page<Citta> findAll (Pageable pageable);

	
	//formula: findBy + OrderBy + NomeColonna + Ordinamento
	List<Citta> findByOrderByNomeDesc();

}
