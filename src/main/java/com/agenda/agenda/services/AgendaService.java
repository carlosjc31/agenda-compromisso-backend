package com.agenda.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.agenda.dtos.AgendaRequest;
import com.agenda.agenda.dtos.AgendaResponse;
import com.agenda.agenda.entities.Agenda;
import com.agenda.agenda.mappers.AgendaMapper;
import com.agenda.agenda.repositories.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    public List<AgendaResponse> getAllAgenda(){
        return repository.findAll()
                         .stream()
                         .map(a -> AgendaMapper.toDTO(a))
                         .collect(Collectors.toList());
    }
    
    public AgendaResponse getAgendaById(Long id){
        Agenda agenda = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Agenda não encontrada")
        );
        return AgendaMapper.toDTO(agenda);
    }

    public AgendaResponse save(AgendaRequest agenda){
        Agenda newAgenda = repository.save(AgendaMapper.toEntity(agenda));
        return AgendaMapper.toDTO(newAgenda);
    }

    public void update(AgendaRequest agenda, Long id){
        Agenda aux = repository.getReferenceById(id);

        aux.setTitle(agenda.title());
        aux.setDescription(agenda.description());
        aux.setDate(agenda.date());
        aux.setLocal(agenda.local());

        repository.save(aux);
    }

    public void delete(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        } 
        else {
            throw new EntityNotFoundException("Agenda não encontrada");            
        }
    }
}
