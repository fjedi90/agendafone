package com.felipeleitao.agenda_telefonica.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.felipeleitao.agenda_telefonica.models.Agenda;
import com.felipeleitao.agenda_telefonica.models.Attendance;
import com.felipeleitao.agenda_telefonica.models.Professional;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class AgendaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nameAgenda;
    private String description;
    private String status;
    private String groupAgenda;
    private String agendaOwnerName;
    private Long agendaOwnerId;
    private String agendaOwnerMat;
    @JsonIgnore
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<Attendance> attendances = new ArrayList<>();

    public AgendaDTO(Agenda agenda, Professional professional) {
        this.id = agenda.getId();
        this.nameAgenda = agenda.getNameAgenda();
        this.description = agenda.getDescription();
        this.status = agenda.getStatus();
        this.groupAgenda = agenda.getGroupAgenda();
        this.agendaOwnerName = professional.getNome();
        this.agendaOwnerId = professional.getId();
        this.agendaOwnerMat = professional.getMatricula();
    }
    public AgendaDTO(Agenda agenda) {
        this.id = agenda.getId();
        this.nameAgenda = agenda.getNameAgenda();
        this.description = agenda.getDescription();
        this.status = agenda.getStatus();
        this.groupAgenda = agenda.getGroupAgenda();
        this.agendaOwnerName = agenda.getAgendaOwnerName();
        this.agendaOwnerId = agenda.getAgendaOwnerId();
        this.agendaOwnerMat = agenda.getAgendaOwnerMat();
    }
}