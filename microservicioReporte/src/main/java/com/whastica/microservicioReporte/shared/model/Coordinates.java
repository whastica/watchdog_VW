package com.whastica.microservicioReporte.shared.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable  // Permite que la clase sea parte de otra entidad como un objeto embebido.
public class Coordinates {

    //@Min(value = -90, message = "La latitud mínima es -90")
    //@Max(value = 90, message = "La latitud máxima es 90")
    private double latitude;

    //@Min(value = -180, message = "La longitud mínima es -180")
    //@Max(value = 180, message = "La longitud máxima es 180")
    private double longitude;

    public boolean isValid() {
        return latitude >= -90 && latitude <= 90 &&
               longitude >= -180 && longitude <= 180;
    }

}