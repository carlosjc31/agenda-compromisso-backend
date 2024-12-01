package com.agenda.agenda.mappers;

import com.agenda.agenda.dtos.AgendaResponse;
import com.agenda.agenda.entities.Agenda;

public class AgendaMapper {
    public static AgendaResponse toDTO(Agenda agenda){
        return new AgendaResponse(agenda.getId(),
        agenda.getTitle(),
        agenda.getDescription(),
        agenda.getDate(),
        agenda.getLocal());
    }
}
