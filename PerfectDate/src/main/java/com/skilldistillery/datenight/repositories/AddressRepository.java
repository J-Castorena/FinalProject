package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
