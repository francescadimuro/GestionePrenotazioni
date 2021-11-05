package it.epicode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.model.Role;
import it.epicode.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleSerrvice;
	
	 @GetMapping("/findAllRoles")
	 List<Role> findRoleAll(){
		 return roleSerrvice.myFindAllRole();
	 }
}
