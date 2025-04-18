package com.whastica.microservicioReporte.query.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Coordinates;
import com.whastica.microservicioReporte.shared.model.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "report") // puedes cambiar el nombre si usas otro
public class ReportQuery {

    @Id
    private String id;

    private String description;

    private UUID citizenId;

    private Status status;

    private CategoryIssue categoryIssue;

    @Embedded
    private Coordinates coordinates;

    private String fotoUrl;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
