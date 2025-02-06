package com.felipeleitao.agenda_telefonica.core;

import com.felipeleitao.agenda_telefonica.dto.AttendanceDTO;
import com.felipeleitao.agenda_telefonica.dto.PersonDTO;
import com.felipeleitao.agenda_telefonica.models.Person;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Person.class, PersonDTO.class)
                .addMapping(Person::getAddresses, PersonDTO::setEnderecos)
//                .<List<AddressDTO>>addMapping(source -> source.getAddresses(),(dest, value) -> dest.setEnderecos(value));
                .addMapping(src -> src.getAttendances(),
                        (dest, value) -> dest.setAtendimentos((List<AttendanceDTO>) value));
        return modelMapper;
    }
}
