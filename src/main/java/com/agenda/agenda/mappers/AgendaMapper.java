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
            agenda.getDate_hora(),
            agenda.getLocal());
    }

    public static Agenda toEntity(AgendaRequest agendaRequest){
        Agenda agenda = new Agenda();

            agenda.setTitle(agendaRequest.title());
            agenda.setDescription(agendaRequest.description());
            agenda.setDate_hora(agendaRequest.date_hora());
            agenda.setLocal(agendaRequest.local());
        
        return agenda;
        
    }
}
