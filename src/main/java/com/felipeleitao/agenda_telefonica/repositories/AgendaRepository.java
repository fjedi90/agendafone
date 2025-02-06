package com.felipeleitao.agenda_telefonica.repositories;

import com.felipeleitao.agenda_telefonica.models.Agenda;
import com.felipeleitao.agenda_telefonica.models.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT a FROM Agenda a")
    Page<Agenda> findAll(PageRequest pageRequest);
}
