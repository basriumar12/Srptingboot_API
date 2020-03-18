package com.example.test.controller;

import com.example.test.model.ModelUser;
import com.example.test.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// manandakan sebagai class controller dan membuat sebuah route dengan nama user.

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	// mengambil semua data user
	@GetMapping("/")
	public List<ModelUser> all(){
		return userRepo.findAll();
	}
	
	// membuat data baru
	@PostMapping("/")
	public ModelUser add(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("address") String address) {
		
		ModelUser modelUser = new ModelUser();
		modelUser.setFirstName(firstName);
		modelUser.setLastName(lastName);
		modelUser.setAddress(address);
		
		return userRepo.save(modelUser);
	}
	
	// mengubah data
	@PutMapping("/{id}")
	public ModelUser update(@PathVariable("id") Long id, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("address") String address) {
		
		ModelUser modelUser = new ModelUser();
		modelUser.setId(id);
		modelUser.setFirstName(firstName);
		modelUser.setLastName(lastName);
		modelUser.setAddress(address);
		
		return userRepo.save(modelUser);
	}
	
	// menghapus data
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		ModelUser modelUser = new ModelUser();
		modelUser.setId(id);
		
		userRepo.delete(modelUser);
	}
	
	// mengambil satu data user
	@GetMapping("/{id}")
	public Optional<ModelUser> find(@PathVariable("id") Long id){
		return userRepo.findById(id);
	}
	
}
