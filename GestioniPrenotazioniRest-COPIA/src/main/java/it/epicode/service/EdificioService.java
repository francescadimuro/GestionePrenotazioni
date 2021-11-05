package it.epicode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.CRUD.CittaRepository;
import it.epicode.CRUD.EdificioRepository;
import it.epicode.model.Citta;
import it.epicode.model.Edificio;
import it.epicode.model.Postazione;
import it.epicode.model.Prenotazione;
import it.epicode.model.TipoPostazione;

@Service
public class EdificioService implements CommandLineRunner {

	@Autowired EdificioRepository edificioRepository;
	@Autowired CittaRepository cittaRep;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public List<Edificio> findAlledificio() {
        return edificioRepository.findAll();
    }
	
	public List<Edificio> myFindByName(String name) {
        return edificioRepository.findbyName(name);
    }
	
	 public String saveEdificio(String nome, String indirizzo, String nomecitta, String codice) {
		List< Citta>listaCitta= cittaRep.findbyName(nomecitta);
		Citta citta1=listaCitta.get(0);
		// Verifica l'esistenza di Username e Email già registrate
	    if (edificioRepository.existsByNome(nomecitta)) {
	        return "Errore, edificio già presente in archivio";
	    }
	    
		edificioRepository.save(new Edificio(nome, indirizzo, citta1, codice));
		return "Savataggio avvenuto";
	 }

	 
	 public Page<Edificio> myFindAllEdificioPageSize(Integer page, Integer size) {
			Pageable paging = PageRequest.of(page, size);
			Page<Edificio> pagedResult = edificioRepository.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult;
			} else {
			return null;
		}
		}


		public List<Edificio> myFindAllEdificioPageSizeSort(Integer page, Integer size, String sort) {
			Pageable paging = PageRequest.of(page, size, Sort.by(sort));
			Page<Edificio> pagedResult = edificioRepository.findAll(paging);
			if ( pagedResult.hasContent()) {
				return pagedResult.getContent();
			} else {
			return null;
		}
	    
	}


		public List<Edificio> myFindAllEdificioSorted() {
			return edificioRepository.findByOrderByNomeDesc();
		}
	} 

