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


import it.epicode.model.User;
import it.epicode.service.UserService;

@RestController
@RequestMapping("/controllerUser")
public class UserController {

	@Autowired
	UserService userService;
	
	 @GetMapping("/findAllUser")
	 List<User> findUserAll(){
		 return userService.myFindAllUsers();
	 }
	 
	 @GetMapping("/saveUser")
	 String saveUser(@RequestParam String username,@RequestParam String nome,@RequestParam String email,@RequestParam String password, @RequestParam boolean active){
		userService.myInserrUser(username, nome, email, password, true);
		 return "Salvataggio user avvenuto con successo";
	 }
	
	 
	 @GetMapping(value = "/finduseralluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
	    public Page myGetAllUserPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
	        Page<User> user = userService.myFindAllUserPageSize(page, size);
	      return user;
	    }
		
		@GetMapping(value = "/mygetalluserpagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<User>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
	      List<User> list = userService.myFindAllUserPageSizeSort(page, size, sort);
	      return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }
		
		@GetMapping(value = "/mygetallusersortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<User> myGetAllusersSortByName() {
	        return userService.myFindAllUserSorted();
	    }
}




