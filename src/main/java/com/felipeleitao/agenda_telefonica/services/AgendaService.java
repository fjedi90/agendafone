package com.felipeleitao.agenda_telefonica.services;

import com.felipeleitao.agenda_telefonica.dto.AgendaDTO;
import com.felipeleitao.agenda_telefonica.models.Agenda;
import com.felipeleitao.agenda_telefonica.models.Professional;
import com.felipeleitao.agenda_telefonica.repositories.AgendaRepository;
import com.felipeleitao.agenda_telefonica.services.exceptions.DataIntegratyViolationException;
import com.felipeleitao.agenda_telefonica.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public Page<AgendaDTO> findAll(Integer page, Integer size) {
        Page<Agenda> agendaPage = repository.findAll(PageRequest.of(page,size));
        return agendaPage.map(x -> new AgendaDTO(x));
    }

    public Agenda findById(Long id) {
        Optional<Agenda> agendaOptional = repository.findById(id);
        return agendaOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Agenda create(AgendaDTO obj) {
        return repository.save(modelMapper.map(obj, Agenda.class));
    }

    public Agenda udpate(AgendaDTO objDto) {
        findById(objDto.getId());
        return repository.save(modelMapper.map(objDto, Agenda.class));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}