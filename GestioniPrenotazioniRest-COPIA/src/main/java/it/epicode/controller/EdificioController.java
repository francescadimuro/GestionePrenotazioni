package it.epicode.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.model.Citta;
import it.epicode.model.Edificio;
import it.epicode.model.Role;
import it.epicode.model.RoleType;
import it.epicode.model.TipoPostazione;
import it.epicode.model.User;
import it.epicode.service.EdificioService;
import it.epicode.sicurezza.EdificioRequest;
import it.epicode.sicurezza.SignupRequest;
import it.epicode.sicurezza.SignupResponse;

@RestController
@RequestMapping("/controllerEdificio")
public class EdificioController {

	@Autowired
	EdificioService edificioService;
	
	
	
	 @GetMapping("/findAllEdificio")
	 List<Edificio> findEdificioAll(){
		 return edificioService.findAlledificio();
	 }
	 
	 @GetMapping("/findByName")
	 List<Edificio> findByName(String name){
		 return edificioService.myFindByName(name);
	 }
	 
	 @GetMapping("/saveEdificio")
	 String saveEdificio(@RequestParam String nome, @RequestParam String indirizzo, @RequestParam String nomeCitta, @RequestParam String codice){
		 edificioService.saveEdificio(nome, indirizzo, nomeCitta, codice);
		 return "Salvataggio edificio avvenuto con successo";
	 }
	 //String codice, String descrizione,Integer numeroMassimoOccupati, TipoPostazione tipoPostazione, String nomeEdificio


    @GetMapping(value = "/findedificioalluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
    Page<Edificio> edificio = edificioService.myFindAllEdificioPageSize(page, size);
    return edificio;
}

   @GetMapping(value = "/mygetalledificiopagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<Edificio>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
    List<Edificio> list = edificioService.myFindAllEdificioPageSizeSort(page, size, sort);
    return new ResponseEntity<List<Edificio>>(list, new HttpHeaders(), HttpStatus.OK); 
}

    @GetMapping(value = "/mygetalledificiosortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Edificio> myGetAllusersSortByName() {
    return edificioService.myFindAllEdificioSorted();
}



   @PostMapping("/salvaEdificio")
   public ResponseEntity<?> registerEdificio(@RequestBody @Valid EdificioRequest edificioRequest) {
   return ResponseEntity.ok(new SignupResponse(edificioService.saveEdificio(edificioRequest.getNome(), edificioRequest.getIndirizzo(), edificioRequest.getNomeCitta(), edificioRequest.getCodice())));

   }
   }


