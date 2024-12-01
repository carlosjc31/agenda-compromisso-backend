package com.agenda.agenda.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record AgendaRequest(
    
    @NotBlank(message = "O título é obrigatório")
    String title,

    @NotBlank(message = "A descrição é obrigatória")
    String description,

    @NotBlank(message = "A data é obrigatória")
    LocalDateTime date,

    @NotBlank(message = "O local é obrigatório")
    String local
) {

}
