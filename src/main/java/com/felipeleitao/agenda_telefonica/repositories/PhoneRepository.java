package com.felipeleitao.agenda_telefonica.repositories;

import com.felipeleitao.agenda_telefonica.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
