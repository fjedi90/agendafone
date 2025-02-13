package com.felipeleitao.agenda_telefonica.controllers;

import com.felipeleitao.agenda_telefonica.dto.ProfessionalDTO;
import com.felipeleitao.agenda_telefonica.models.Professional;
import com.felipeleitao.agenda_telefonica.services.ProfessionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/professional")
public class ProfessionalController {

    @Autowired
    ProfessionalService service;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<List<Professional>> findAll(){
        List<Professional> professionalList = service.findAll();
        return ResponseEntity.ok().body(professionalList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalDTO> getOneProfessional(@PathVariable("id") Long id){
        Professional professional = service.findById(id);
        ProfessionalDTO professionalDTO = modelMapper.map(professional, ProfessionalDTO.class);
        return ResponseEntity.ok().body(professionalDTO);
    }

    @GetMapping()
    public ResponseEntity<Page<ProfessionalDTO>> searchByNameOrCpfOrMatricula(
            @RequestParam(value="search", defaultValue="") String search,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
            @RequestParam(value="direction", defaultValue="DESC") String direction){
        Page<ProfessionalDTO> professionalDTOList = service.findByNameOrCpfOrMatricula(search, page, size, orderBy, direction);
        return ResponseEntity.ok().body(professionalDTOList);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProfessionalDTO obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(service.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalDTO> update(@PathVariable Long id, @RequestBody ProfessionalDTO objDto){
        objDto.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(service.udpate(objDto), ProfessionalDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessionalDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
