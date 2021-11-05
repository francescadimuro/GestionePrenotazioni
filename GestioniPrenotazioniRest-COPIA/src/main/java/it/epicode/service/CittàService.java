package it.epicode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.CRUD.CittaRepository;
import it.epicode.model.Citta;
import it.epicode.model.Prenotazione;

@Service
public class CittàService implements CommandLineRunner {

	@Autowired
	static CittaRepository cittaRepository;
	
	@Override
	public void run(String... args) throws Exception {

		
	}

	
	public List<Citta> myFindAll() {
        return cittaRepository.findAll();
    }
	
	public List<Citta> myFindByName(String name) {
        return cittaRepository.findbyName(name);
    }

    
    public Optional<Citta> findById(Long myId) {
        return cittaRepository.findById(myId);
    }
    
    public void myInsertCitta(String nome) {
        cittaRepository.save(new Citta(nome));
    }


	public Page<Citta> myFindAllCittàPageSize(Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Citta> pagedResult = cittaRepository.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
		return null;
	}
	}


	public List<Citta> myFindAllCittàPageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Citta> pagedResult = cittaRepository.findAll(paging);
		if ( pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
		return null;
	}
    
}


	public List<Citta> myFindAllCittàSorted() {
		return cittaRepository.findByOrderByNomeDesc();
	}
} 
     

    
