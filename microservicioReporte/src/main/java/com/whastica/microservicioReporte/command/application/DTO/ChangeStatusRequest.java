package com.whastica.microservicioReporte.command.application.DTO;

import com.whastica.microservicioReporte.shared.model.Status;
import lombok.Data;

@Data
public class ChangeStatusRequest {
    private Status newStatus;
}