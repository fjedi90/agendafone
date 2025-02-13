package com.felipeleitao.agenda_telefonica.repositories;

import com.felipeleitao.agenda_telefonica.models.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT new Professional(p.id, p.nome, p.cpf, p.matricula, p.especialidade) " +
            "FROM Professional p")
    Page<Professional> findAllPaged(PageRequest pageRequest);

    @Transactional(readOnly = true)
    @Query("SELECT p FROM Professional p WHERE p.cpf LIKE %:search% " +
            "OR p.matricula LIKE %:search%")
    Page<Professional> findByCpfOrMatricula(@Param("search")String search, Pageable pageable);

    @Transactional(readOnly = true)
    Page<Professional> findByNomeContainingIgnoreCase(String search, Pageable pageable);

    @Transactional(readOnly = true)
    Optional<Professional> findByCpf(String cpf);

    @Transactional(readOnly = true)
    Optional<Professional> findByEmail(String cpf);

    @Transactional(readOnly = true)
    Optional<Professional> findByMatricula(String matricula);
}