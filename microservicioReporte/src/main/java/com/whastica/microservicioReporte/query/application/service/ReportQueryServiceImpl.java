package com.whastica.microservicioReporte.query.application.service;

import com.whastica.microservicioReporte.command.domain.model.Report;
import com.whastica.microservicioReporte.query.application.DTO.ReportQueryResponse;
import com.whastica.microservicioReporte.query.application.interfaces.ReportQueryServiceInterface;
import com.whastica.microservicioReporte.query.domain.model.ReportQuery;
import com.whastica.microservicioReporte.query.domain.repository.ReportQueryRepository;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReportQueryServiceImpl implements ReportQueryServiceInterface {

    @Autowired
    private ReportQueryRepository reportQueryRepository;

    @Override
    public ReportQueryResponse getReportById(String id) {
        ReportQuery report = reportQueryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));
        return mapToResponse(report);
    }

    @Override
    public List<ReportQueryResponse> getAllReports() {
        List<ReportQuery> reports = reportQueryRepository.findAll();
        System.out.println("Reportes encontrados: " + reports.size());
        return reports.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportQueryResponse> getReportsByCitizenId(String citizenId) {
        return reportQueryRepository.findByCitizenId(citizenId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportQueryResponse> getReportsByStatus(Status status) {
        return reportQueryRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportQueryResponse> getReportsByCategoryIssue(CategoryIssue categoryIssue) {
        return reportQueryRepository.findByCategoryIssue(categoryIssue)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ReportQueryResponse mapToResponse(ReportQuery report) {
        return new ReportQueryResponse(
                report.getId(),
                report.getDescription(),
                report.getCitizenId(),
                report.getStatus(),
                report.getCategoryIssue(),
                report.getCoordinates(),
                report.getFotoUrl(),
                report.getCreateDate(),
                report.getUpdateDate()
        );
    }
}