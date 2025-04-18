package com.whastica.microservicioReporte.query.infra.controller;

import com.whastica.microservicioReporte.query.application.DTO.ReportQueryResponse;
import com.whastica.microservicioReporte.query.application.interfaces.ReportQueryServiceInterface;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/query/report")
public class QueryReportController {

    @Autowired
    private ReportQueryServiceInterface reportQueryService;

    @GetMapping("/{id}")
    public ReportQueryResponse getReportById(@PathVariable String id) {
        return reportQueryService.getReportById(id);
    }

    @GetMapping
    public List<ReportQueryResponse> getAllReports() {
        return reportQueryService.getAllReports();
    }

    @GetMapping("/citizen/{citizenId}")
    public List<ReportQueryResponse> getReportsByCitizenId(@PathVariable String citizenId) {
        return reportQueryService.getReportsByCitizenId(citizenId);
    }

    @GetMapping("/status")
    public List<ReportQueryResponse> getReportsByStatus(@RequestParam Status status) {
        return reportQueryService.getReportsByStatus(status);
    }

    @GetMapping("/category")
    public List<ReportQueryResponse> getReportsByCategoryIssue(@RequestParam CategoryIssue category) {
        return reportQueryService.getReportsByCategoryIssue(category);
    }
}
