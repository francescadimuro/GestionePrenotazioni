package it.epicode.CRUD;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import it.epicode.model.Edificio;



public interface EdificioRepository extends JpaRepository<Edificio, Long> {

	@Query("SELECT u FROM Edificio u WHERE u.nome = :nome" )
	List<Edificio> findbyName(String nome);
	
   Page<Edificio> findAll (Pageable pageable);

	
	//formula: findBy + OrderBy + NomeColonna + Ordinamento
	List<Edificio> findByOrderByNomeDesc();
    public Boolean existsByNome(String nome);
}
