package com.skilldistillery.datenight.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.Address;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.services.AddressService;
import com.skilldistillery.datenight.services.UserService;

@CrossOrigin({ "*", "http://localhost/" })
@RestController
@RequestMapping("api")
public class AddressController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private AddressService addressServ;
	
	@GetMapping("addresses")
	public List<Address> findAllAddresses(Principal principal){
		return addressServ.index();
	}
	
	@GetMapping("addresses/{addressId}")
	public Address findAddressById(@PathVariable int addressId, Principal principal, HttpServletResponse res) {
		Address resultAddress = addressServ.findAddressById(principal.getName(), addressId);
		if(resultAddress == null) {
			res.setStatus(404);
		}
	return resultAddress;
	}
	
	@PostMapping("/users/{userId}/addresses")
	public Address createUserAddress(@RequestBody Address address, @PathVariable int userId, HttpServletResponse res) {
		Address userAddress = addressServ.createUserAddress(address, userId);
		return userAddress;
	}
	
	@PostMapping("/datenights/{dateNightId}/addresses")
	public Address createDateNightAddress(@RequestBody Address address, @PathVariable int dateNightId, HttpServletResponse res) {
		Address dateNightAddress = addressServ.createDateNightAddress(address, dateNightId);
		return dateNightAddress;
	}
	
	
	//NOT POSTING
	@PutMapping("/addresses/{addressId}")
	public Address editAddress(@RequestBody Address address, @PathVariable int addressId, HttpServletResponse res, Principal principal) {
		
			
		address= addressServ.updateAddress(principal.getName(), address);
		return address;
	}
	
	
	//NOT WORKING
	@DeleteMapping("addresses/{addressId}")
		public void destroyAddress(@PathVariable int addressId, Principal principal, HttpServletResponse res) {
		 boolean addressDeleted = addressServ.deleteAddress(principal.getName(), addressId);	
		if(addressDeleted) {
				res.setStatus(204);
		}else {
			res.setStatus(404);
		}
	}
	
}
