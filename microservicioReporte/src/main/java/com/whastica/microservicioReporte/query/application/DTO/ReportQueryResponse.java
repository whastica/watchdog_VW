package com.whastica.microservicioReporte.query.application.DTO;

import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Coordinates;
import com.whastica.microservicioReporte.shared.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportQueryResponse {

    private String id;

    private String description;

    private UUID citizenId;

    private Status status;

    private CategoryIssue categoryIssue;

    private Coordinates coordinates;

    private String fotoUrl;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
