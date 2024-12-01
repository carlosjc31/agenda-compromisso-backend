package com.agenda.agenda.dtos;

import java.time.LocalDateTime;

public record AgendaResponse(
    Long id,
    String title,
    String description,
    LocalDateTime date,
    String local
) {
    
}
