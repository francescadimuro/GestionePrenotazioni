
package it.epicode.CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.model.Citta;
import it.epicode.model.User;



public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.nome = :nome" )
	List<User> findbyName(String nome);
	
	@Query("SELECT u FROM User u WHERE u.username = :username" )
	List<User> findbyUserName(String username);
	
    Page<User> findAll (Pageable pageable);

	
	//formula: findBy + OrderBy + NomeColonna + Ordinamento
	List<User> findByOrderByUsernameDesc();

	Optional<User> findByUsername(String nome);
	
	Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
