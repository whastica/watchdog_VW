package com.whastica.microservicioReporte.query.infra.config;

import com.whastica.microservicioReporte.Sync.ReportCreatedEvent;
import com.whastica.microservicioReporte.Sync.ReportDeletedEvent;
import com.whastica.microservicioReporte.Sync.ReportStatusChangedEvent;
import com.whastica.microservicioReporte.Sync.ReportUpdatedEvent;
import com.whastica.microservicioReporte.query.domain.model.ReportQuery;
import com.whastica.microservicioReporte.query.domain.repository.ReportQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReportEventHandler {

    @Autowired
    private ReportQueryRepository reportQueryRepository;

    @EventListener
    public void handleReportCreated(ReportCreatedEvent event) {
        ReportQuery report = new ReportQuery(
                event.getId(),
                event.getDescription(),
                event.getCitizenId(),
                event.getStatus(),
                event.getCategoryIssue(),
                event.getCoordinates(),
                event.getFotoUrl(),
                event.getCreateDate(),
                null
        );
        reportQueryRepository.save(report);
    }

    @EventListener
    public void handleReportUpdated(ReportUpdatedEvent event) {
        reportQueryRepository.findById(event.getId()).ifPresent(report -> {
            report.setDescription(event.getDescription());
            report.setCategoryIssue(event.getCategoryIssue());
            report.setCoordinates(event.getCoordinates());
            report.setFotoUrl(event.getFotoUrl());
            report.setUpdateDate(event.getUpdateDate());
            reportQueryRepository.save(report);
        });
    }

    @EventListener
    public void handleReportStatusChanged(ReportStatusChangedEvent event) {
        reportQueryRepository.findById(event.getId()).ifPresent(report -> {
            report.setStatus(event.getNewStatus());
            report.setUpdateDate(event.getUpdateDate());
            reportQueryRepository.save(report);
        });
    }

    @EventListener
    public void handleReportDeleted(ReportDeletedEvent event) {
        reportQueryRepository.deleteById(event.getId());
    }
}