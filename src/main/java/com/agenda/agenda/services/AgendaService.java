package com.agenda.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.agenda.dtos.AgendaResponse;
import com.agenda.agenda.mappers.AgendaMapper;
import com.agenda.agenda.repositories.AgendaRepository;

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
    
}
