package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Address;
import com.skilldistillery.datenight.entities.DateNight;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.AddressRepository;
import com.skilldistillery.datenight.repositories.DateNightRepository;
import com.skilldistillery.datenight.repositories.UserRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addyRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DateNightRepository dateNightRepo;
	
	@Override
	public List<Address> index() {
		return addyRepo.findAll();
	}

	
	//FIX ME
	@Override
	public Address findAddressByUserId(int userId, int addyId, String username) {
		Address result = null;
		User user = userRepo.findByUsername(username);
		Optional<Address> addressOp = addyRepo.findById(addyId);
		if(addressOp.isPresent() && user.getUsername().equals(username)) {
			
			result = addressOp.get();
		}
		return result;
	}

	@Override
	public Address findAddressByDateNightId(int dateNightId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//ASK TEAM
	@Override
	public Address findAddressById(String username, int addressId) {
		Address result = null;
		Optional<Address> addressOp = addyRepo.findById(addressId);
		if(addressOp.isPresent()) {
			result = addressOp.get();
		}
		return result;
	}
	
	

	@Override
	public Address createUserAddress(Address address, int userId) {
		Optional<User> userOp = userRepo.findById(userId);
		if(userOp.isPresent()) {
		User user = userOp.get();	
		addyRepo.saveAndFlush(address);
		user.setAddress(address);
		userRepo.saveAndFlush(user);
		return address;
		}
		return null;
	}

	@Override
	public Address createDateNightAddress(Address address, int dateId) {
	
		DateNight dnight = dateNightRepo.findDateNightById(dateId);
		addyRepo.saveAndFlush(address);
		dnight.setAddress(address);
		dateNightRepo.saveAndFlush(dnight);
		return address;
	}
	

	@Override
	public Address updateAddress(String username, Address address) {
		Address existing = findAddressById(username, address.getId());
		if(existing == null) {
			return null;
		}
		existing.setStreet(address.getStreet());
		existing.setCity(address.getCity());
		existing.setState(address.getState());
		existing.setZip(address.getZip());
		return addyRepo.saveAndFlush(existing);
		
		
//		User user = userRepo.findByUsername(username);
//		Address userAddress = user.getAddress();
//		
//		if(address.getId() == userAddress.getId()) {
//			user.setAddress(address);
//			userRepo.saveAndFlush(user);
//			addyRepo.saveAndFlush(address);
//		}
//		return null;
	}

	@Override
	public boolean deleteAddress(String username,int addressId) {
		boolean deleteAddress= false;
		if(addyRepo.existsById(addressId)) {
			addyRepo.deleteById(addressId);
			deleteAddress= true;
		}
		return deleteAddress;
		
		//DIFFERENT WAYS I TRIED TO MAKE IT WORK
		///////////////////////////////////////////
		
//		
//		addyRepo.deleteById(addressId);
//		return !addyRepo.existsById(addressId);
		
		
		//////////////////////////////////////////
//		boolean deleted = false;
		
//		User user = userRepo.findByUsername(username);
//		if(user.getAddress().getId() == addressId) {
//			deleted = true;
//			addyRepo.deleteById(addressId);
//		}
//		return deleted;
	}

	//ORIGINAL
	@Override
	public Address updateAddress(Address address, int addressId) {
		return null;
	}



}
