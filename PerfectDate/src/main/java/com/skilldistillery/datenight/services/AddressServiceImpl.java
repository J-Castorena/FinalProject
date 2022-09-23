package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Address;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.AddressRepository;
import com.skilldistillery.datenight.repositories.UserRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addyRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Address> index() {
		return addyRepo.findAll();
	}

	@Override
	public Address findAddressByUserId(int userId, int addyId) {
		Address result = null;
		Optional<Address> addressOp = addyRepo.findById(addyId);
		if(addressOp.isPresent()) {
			result = addressOp.get();
		}
		return result;
	}

	@Override
	public Address findAddressByDateNightId(int dateNightId) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public Address updateAddress(Address address, int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAddress(int addressId) {
		// TODO Auto-generated method stub
		return false;
	}



}
