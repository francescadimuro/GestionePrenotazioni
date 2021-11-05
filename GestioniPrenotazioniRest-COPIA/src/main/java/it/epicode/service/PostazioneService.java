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

import it.epicode.CRUD.EdificioRepository;
import it.epicode.CRUD.PostazioneRepository;
import it.epicode.model.Citta;
import it.epicode.model.Edificio;
import it.epicode.model.Postazione;
import it.epicode.model.TipoPostazione;


@Service
public class PostazioneService implements CommandLineRunner {

	@Autowired PostazioneRepository postazioneRepository;
	@Autowired EdificioRepository edificioRep;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<Postazione> myFindAllPostazione() {
        return postazioneRepository.findAll();
    }
    
    public Optional<Postazione> myFindPostazioneById(Long myId) {
        return postazioneRepository.findById(myId);
    }
    
    public void savePostazione(String codice, String descrizione,Integer numeroMassimoOccupati, TipoPostazione tipoPostazione, String nomeEdificio) {
    	List<Edificio> listaEd = edificioRep.findbyName(nomeEdificio);
    	Edificio edificio1=listaEd.get(0);
        postazioneRepository.save(new Postazione(codice, descrizione, numeroMassimoOccupati, tipoPostazione, edificio1));
    }
   
    
    public List<Postazione> myFindByTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepository.myFindByTipoECitta(tipo, citta);
    }
    
    public List<Postazione> myFindByTipo(TipoPostazione tipo) {
        return postazioneRepository.myFindByTipo(tipo);
    }
    
    public Postazione getPostById(Long id) {
    	return postazioneRepository.getById(id);
    }
    
    public Page<Postazione> myFindAllPostazionePageSize(Integer page, Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Postazione> pagedResult = postazioneRepository.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult;
		} else {
		return null;
	}
	}


	public List<Postazione> myFindAllPostazionePageSizeSort(Integer page, Integer size, String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Postazione> pagedResult = postazioneRepository.findAll(paging);
		if ( pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
		return null;
	}
    
}


	public List<Postazione> myFindAllPostazioneSorted() {
		return postazioneRepository.findByOrderByCodiceDesc();
	}
} 


    
//    public Postazione getPostByCodice(Long id) {
//    	return postazioneRepository.getById(id);
//    }

