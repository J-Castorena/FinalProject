package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.datenight.entities.Address;
import com.skilldistillery.datenight.entities.User;

public interface AddressService {

	 List<Address> index();
	
	 Address findAddressByUserId(int userId, int addyId);
	
	 Address findAddressByDateNightId(int dateNightId);
	
	 Address createUserAddress(Address address, int userId);
	 
	 Address createDateNightAddress(Address address, int dateId);
	 
	 Address updateAddress(Address address, int addressId);
	 
	 boolean deleteAddress(int addressId);
	
}
