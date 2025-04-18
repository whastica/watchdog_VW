package com.whastica.microservicioReporte.command.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import com.whastica.microservicioReporte.shared.model.Coordinates;
import com.whastica.microservicioReporte.shared.model.Status;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;

@Entity
@Data                   // Genera los getters, setters, toString, equals, y hashCode.
@AllArgsConstructor      // Genera un constructor con todos los campos.
@NoArgsConstructor
public class Report {

    @Id
    @Column(name = "_id", length = 50)
    private String id;

    private String description;

    @Column(name = "citizen_id") // opcional
    private UUID citizenId;

    @Enumerated(EnumType.STRING)  // Mapeo del enum Status como String en la BD
    private Status status;

    @Enumerated(EnumType.STRING)  // Mapeo del enum Status como String en la BD
    private CategoryIssue categoryIssue;

    @Embedded   // Mapeo de las coordenadas como un objeto embebido
    private Coordinates coordinates;
    
    private LocalDateTime createDate;
    
    private LocalDateTime updateDate;

    private String fotoUrl;

    
    
    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();   // Inicialización automática en creación
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();   // Actualización automática al modificar
    }

 
}
