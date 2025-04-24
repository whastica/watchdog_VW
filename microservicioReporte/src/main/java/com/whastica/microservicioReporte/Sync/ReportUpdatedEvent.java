package com.whastica.microservicioReporte.Sync;

import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReportUpdatedEvent {
    private String id;
    private String description;
    private CategoryIssue categoryIssue;
    private Coordinates coordinates;
    private String fotoUrl;
    private LocalDateTime updateDate;
}
