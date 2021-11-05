package it.epicode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import it.epicode.CRUD.RoleRepository;
import it.epicode.model.Role;

@Service
public class RoleService implements CommandLineRunner {

	@Autowired RoleRepository roleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

	public List<Role> myFindAllRole() {
        return roleRepository.findAll();
    }
}
