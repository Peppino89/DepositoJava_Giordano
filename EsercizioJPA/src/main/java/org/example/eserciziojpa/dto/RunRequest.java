package org.example.eserciziojpa.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.eserciziojpa.model.Location;

import java.time.LocalDateTime;

public record RunRequest(

        @NotBlank(message = "Il titolo è obbligatorio")
        @Size(min = 3, max = 100, message = "Il titolo deve avere tra i 3 e i 100 caratteri")
        String title,

        @NotNull(message = "La data di inizio è obbligatoria")
        LocalDateTime startedOn,

        @NotNull(message = "La data di fine è obbligatoria")
        LocalDateTime completedOn,

        @NotNull(message = "La distanza è obbligatoria")
        @Positive(message = "La distanza percorsa deve essere positiva")
        @Max(value = 200, message = "Non si può registrare oltre i 200 chilometri")
        Integer miles,

        @NotNull(message = "La location è obbligatoria")
        Location location

) {}
