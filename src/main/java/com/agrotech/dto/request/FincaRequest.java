package com.agrotech.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record FincaRequest(

        @NotBlank
        String nombreFinca,

        @NotNull
        @Positive
        Double hectareas,

        @NotNull
        Integer idUbicacion

) {
}
