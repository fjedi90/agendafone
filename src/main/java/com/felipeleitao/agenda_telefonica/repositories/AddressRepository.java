package com.felipeleitao.agenda_telefonica.repositories;

import com.felipeleitao.agenda_telefonica.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
