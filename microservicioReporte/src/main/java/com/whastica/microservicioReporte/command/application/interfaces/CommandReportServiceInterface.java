package com.whastica.microservicioReporte.command.application.interfaces;

import com.whastica.microservicioReporte.command.application.DTO.ChangeStatusRequest;
import com.whastica.microservicioReporte.command.application.DTO.CreateReportRequest;
import com.whastica.microservicioReporte.command.application.DTO.UpdateReportRequest;

public interface CommandReportServiceInterface {
    String createReport(CreateReportRequest request);
    void updateReport(String id, UpdateReportRequest request);
    void updateReportStatus(String id, ChangeStatusRequest request);
    void deleteReport(String id);
}