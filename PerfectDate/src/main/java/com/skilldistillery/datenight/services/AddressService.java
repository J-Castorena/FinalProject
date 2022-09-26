package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.datenight.entities.Address;
import com.skilldistillery.datenight.entities.User;

public interface AddressService {

	List<Address> index();

	Address findAddressByUserId(int userId, int addyId, String username);

	Address findAddressByDateNightId(int dateNightId);

	Address createUserAddress(Address address, int userId);

	Address createDateNightAddress(Address address, int dateId);


	boolean deleteAddress(String username, int addressId);

	Address findAddressById(String username, int addressId);

	Address updateAddress(String username, Address address);

}
