package org.opendevup.service;

import java.util.List;

import org.opendevup.Dao.RoleRepository;
import org.opendevup.Dao.UserRepository;
import org.opendevup.entitee.Role;
import org.opendevup.entitee.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured(value={"ROLE_ADMIN"})
public class UserRestService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/addUser")
	public User saveUser(User u){
		return userRepository.save(u);
	}
	
	@RequestMapping(value="/findUsers")
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@RequestMapping(value="/addRole")
	public Role saveRole(Role r){
		return roleRepository.save(r);
	}
	
	@RequestMapping(value="/findRoles")
	public List<Role> findRoles(){
		return roleRepository.findAll();
	}
	@RequestMapping(value="/addRoleToUser")
	public User addRoleToUser(String username,String role){
		User u=userRepository.findOne(username);
		Role r=roleRepository.findOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
	}

}
