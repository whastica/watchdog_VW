package com.whastica.microservicioReporte.command.application.DTO;

import com.whastica.microservicioReporte.shared.model.Coordinates;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import lombok.Data;

@Data
public class UpdateReportRequest {
    private String description;
    private CategoryIssue categoryIssue;
    private Coordinates coordinates;
    private String fotoUrl;
}
