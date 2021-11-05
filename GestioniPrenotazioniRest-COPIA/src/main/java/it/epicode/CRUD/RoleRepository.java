package it.epicode.CRUD;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.model.Role;
import it.epicode.model.RoleType;




public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleType(RoleType roletype);
}
