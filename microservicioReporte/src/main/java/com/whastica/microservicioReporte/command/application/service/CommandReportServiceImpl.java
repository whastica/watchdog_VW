package com.whastica.microservicioReporte.command.application.service;

import com.whastica.microservicioReporte.Sync.ReportCreatedEvent;
import com.whastica.microservicioReporte.Sync.ReportDeletedEvent;
import com.whastica.microservicioReporte.Sync.ReportStatusChangedEvent;
import com.whastica.microservicioReporte.Sync.ReportUpdatedEvent;
import com.whastica.microservicioReporte.command.application.DTO.ChangeStatusRequest;
import com.whastica.microservicioReporte.command.application.DTO.CreateReportRequest;
import com.whastica.microservicioReporte.command.application.DTO.UpdateReportRequest;
import com.whastica.microservicioReporte.command.application.interfaces.CommandReportServiceInterface;
import com.whastica.microservicioReporte.command.domain.model.Report;
import com.whastica.microservicioReporte.command.domain.repository.CommandReportRepository;

import com.whastica.microservicioReporte.shared.model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;
import java.util.UUID;

@Service
public class CommandReportServiceImpl implements CommandReportServiceInterface {

    @Autowired
    private CommandReportRepository reportRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public String createReport(CreateReportRequest request) {
        Report report = new Report();
        report.setId(UUID.randomUUID().toString());
        report.setDescription(request.getDescription());
        report.setCitizenId(request.getCitizenId() != null ? UUID.fromString(request.getCitizenId()) : null);
        report.setStatus(Status.EN_LISTA); // Estado inicial
        report.setCategoryIssue(request.getCategoryIssue());
        report.setCoordinates(request.getCoordinates());
        report.setFotoUrl(request.getFotoUrl());

        reportRepository.save(report);


        eventPublisher.publishEvent(new ReportCreatedEvent(
                report.getId(),
                report.getDescription(),
                report.getCitizenId(),
                report.getStatus(),
                report.getCategoryIssue(),
                report.getCoordinates(),
                report.getFotoUrl(),
                report.getCreateDate()
        ));

        return report.getId();
    }

    @Override
    public void updateReport(String id, UpdateReportRequest request) {
        Optional<Report> optionalReport = reportRepository.findById(id);
        if (optionalReport.isEmpty()) {
            throw new RuntimeException("Reporte no encontrado con id: " + id);
        }

        Report report = optionalReport.get();
        report.setDescription(request.getDescription());
        report.setFotoUrl(request.getFotoUrl());
        report.setCategoryIssue(request.getCategoryIssue());
        report.setCoordinates(request.getCoordinates());
        reportRepository.save(report);


        eventPublisher.publishEvent(new ReportUpdatedEvent(
                report.getId(),
                report.getDescription(),
                report.getCategoryIssue(),
                report.getCoordinates(),
                report.getFotoUrl(),
                report.getUpdateDate()
        ));
    }

    @Override
    public void updateReportStatus(String id, ChangeStatusRequest request) {
        Optional<Report> optionalReport = reportRepository.findById(id);
        if (optionalReport.isEmpty()) {
            throw new RuntimeException("Reporte no encontrado con id: " + id);
        }

        Report report = optionalReport.get();
        report.setStatus(request.getNewStatus());
        reportRepository.save(report);


        eventPublisher.publishEvent(new ReportStatusChangedEvent(
                report.getId(),
                report.getStatus(),
                report.getUpdateDate()
        ));
    }

    @Override
    public void deleteReport(String id) {
        if (!reportRepository.existsById(id)) {
            throw new RuntimeException("Reporte no encontrado con id: " + id);
        }

        reportRepository.deleteById(id);

        eventPublisher.publishEvent(new ReportDeletedEvent(id));
    }
}