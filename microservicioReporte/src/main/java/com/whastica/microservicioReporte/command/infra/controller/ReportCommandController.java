package com.whastica.microservicioReporte.command.infra.controller;

import com.whastica.microservicioReporte.command.application.DTO.ChangeStatusRequest;
import com.whastica.microservicioReporte.command.application.DTO.CreateReportRequest;
import com.whastica.microservicioReporte.command.application.DTO.UpdateReportRequest;
import com.whastica.microservicioReporte.command.application.interfaces.CommandReportServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportCommandController {

    @Autowired
    private CommandReportServiceInterface reportService;

    @PostMapping
    public ResponseEntity<String> createReport(@RequestBody CreateReportRequest request) {
        String reportId = reportService.createReport(request);
        return new ResponseEntity<>(reportId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReport(@PathVariable String id, @RequestBody UpdateReportRequest request) {
        reportService.updateReport(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateReportStatus(@PathVariable String id, @RequestBody ChangeStatusRequest request) {
        reportService.updateReportStatus(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable String id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}