package it.epicode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.model.Citta;
import it.epicode.model.Edificio;
import it.epicode.model.Postazione;
import it.epicode.model.TipoPostazione;
import it.epicode.service.PostazioneService;

@RestController
@RequestMapping("/controllerPostazione")
public class PostazioneController {

	@Autowired
	PostazioneService postazioneService;
	
	
	 @GetMapping("/findPostazione")
	 List<Postazione> findPostazione(@RequestParam TipoPostazione tipo, @RequestParam String citta){
		 return postazioneService.myFindByTipoECitta(tipo, citta);
	 }
	 
	 @GetMapping("/findAllPostazione")
	 List<Postazione> findPostazioneAll(){
		 return postazioneService.myFindAllPostazione();
	 }
	 
	 @GetMapping("/findByTipo")
	 List<Postazione> findByTipo(String tipo){
		 return postazioneService.myFindByTipo(null);
	 }
	 
	 @GetMapping("/savePostazione")
	 String savePostazione(@RequestParam String codice, @RequestParam String descrizione, @RequestParam Integer numeroMassimoOccupati,
			 @RequestParam TipoPostazione tipoPostazione, @RequestParam String nomeEdificio){
		 postazioneService.savePostazione(codice, descrizione, numeroMassimoOccupati, tipoPostazione, nomeEdificio);
		 return "Salvataggio edificio avvenuto con successo";
	 }
	 


    @GetMapping(value = "/findpostazionealluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
    Page<Postazione> postazione = postazioneService.myFindAllPostazionePageSize(page, size);
     return postazione;
}

    @GetMapping(value = "/mygetallpostazionepagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Postazione>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
    List<Postazione> list = postazioneService.myFindAllPostazionePageSizeSort(page, size, sort);
    return new ResponseEntity<List<Postazione>>(list, new HttpHeaders(), HttpStatus.OK); 
}

   @GetMapping(value = "/mygetallpostazionesortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Postazione> myGetAllusersSortByName() {
    return postazioneService.myFindAllPostazioneSorted();
}
}


/*
 *  @GetMapping("/mygetquery")
    String myGetQuery(@RequestParam String myId, @RequestParam String myName) {
        return "My Spring REST Query: " + myId + ", " + myName;
 * 
 * 
 * 
 * 
 *  public List<Postazione> myFindByTipoECitta(TipoPostazione tipo, Città citta) {
        return postazioneRepository.myFindByTipoECitta(tipo, citta.getNome());
    }
 * */
