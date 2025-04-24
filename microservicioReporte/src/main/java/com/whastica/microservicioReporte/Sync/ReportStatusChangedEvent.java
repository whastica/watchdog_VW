package com.whastica.microservicioReporte.Sync;

import com.whastica.microservicioReporte.shared.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReportStatusChangedEvent {
    private String id;
    private Status newStatus;
    private LocalDateTime updateDate;
}