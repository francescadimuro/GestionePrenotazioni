package it.epicode.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import it.epicode.model.Postazione;
import it.epicode.model.TipoPostazione;
import it.epicode.service.CittàService;

@RestController
@RequestMapping("/controllerCitta")
public class CittaController {

	@Autowired
	CittàService cittaService;
	
	
	 @GetMapping("/findAllCitta")
	 List<Citta> findCittaAll(){
		 return cittaService.myFindAll();
	 }
	 
	 @GetMapping("/findByName")
	 List<Citta> findByName(String name){
		 return cittaService.myFindByName(name);
	 }
	 
	 @GetMapping("/saveCitta")
	 String saveCitta(@RequestParam String nomeCitta){
		 cittaService.myInsertCitta(nomeCitta);
		 return "Salvataggio città avvenuto con successo";
	 }
	 
	 @GetMapping(value = "/findcittaalluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Page myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
	        Page<Citta> citta = cittaService.myFindAllCittàPageSize(page, size);
	        return citta;
	       
	    }
		
		@GetMapping(value = "/mygetallcittapagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Citta>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
	      List<Citta> list = cittaService.myFindAllCittàPageSizeSort(page, size, sort);
	      return new ResponseEntity<List<Citta>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }
		
		@GetMapping(value = "/mygetallcittasortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Citta> myGetAllusersSortByName() {
	        return cittaService.myFindAllCittàSorted();
	    }
}
