package com.whastica.microservicioReporte.command.application.DTO;

import com.whastica.microservicioReporte.shared.model.Coordinates;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateReportRequest {
    private String description;
    private String citizenId;
    private CategoryIssue categoryIssue;
    private Coordinates coordinates;
    private String fotoUrl;
}