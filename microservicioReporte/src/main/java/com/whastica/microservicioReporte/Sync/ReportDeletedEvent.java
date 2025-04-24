package com.whastica.microservicioReporte.Sync;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportDeletedEvent {
    private String id;
}
