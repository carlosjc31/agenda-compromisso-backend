package com.agenda.agenda.mappers;

import com.agenda.agenda.dtos.AgendaRequest;
import com.agenda.agenda.dtos.AgendaResponse;
import com.agenda.agenda.entities.Agenda;

public class AgendaMapper {
    public static AgendaResponse toDTO(Agenda agenda){
        return new AgendaResponse(
            agenda.getId(),
            agenda.getTitle(),
            agenda.getDescription(),
            agenda.getDate(),
            agenda.getLocal());
    }

    public static Agenda toEntity(AgendaRequest agendaRequest){
        Agenda agenda = new Agenda();

            agenda.setTitle(agendaRequest.title());
            agenda.setDescription(agendaRequest.description());
            agenda.setDate(agendaRequest.date());
            agenda.setLocal(agendaRequest.local());
        
        return agenda;
        
    }
}
