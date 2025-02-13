package com.felipeleitao.agenda_telefonica.controllers;

import com.felipeleitao.agenda_telefonica.dto.EventDTO;
import com.felipeleitao.agenda_telefonica.models.Event;
import com.felipeleitao.agenda_telefonica.services.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/event")
public class EventController {

    @Autowired
    EventService service;
    @Autowired
    ModelMapper mapper;

    @GetMapping()
    public ResponseEntity<List<EventDTO>> getAllOrGetByName(
            @RequestParam(value="search", defaultValue="") String name,
            @RequestParam(value="pastdate", defaultValue="true") Boolean pastDate,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value="orderBy", defaultValue="dateUTC") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction){
        Page<EventDTO> eventDTOS = service.findAllOrFindByName(name, pastDate, page, size, orderBy, direction);
        return ResponseEntity.ok().body(eventDTOS.getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getOneEvent(@PathVariable("id") UUID id){
        Event event = service.findById(id);
        EventDTO eventDTO = mapper.map(event, EventDTO.class);
        return ResponseEntity.ok().body(eventDTO);
    }

    @PostMapping()
    public ResponseEntity<EventDTO> create(@RequestBody EventDTO obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();
//        return ResponseEntity.created(uri).build();
        return new ResponseEntity<EventDTO>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventDTO> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
