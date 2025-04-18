package com.whastica.microservicioReporte.query.application.interfaces;

import com.whastica.microservicioReporte.query.application.DTO.ReportQueryResponse;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Status;

import java.util.List;
import java.util.UUID;

public interface ReportQueryServiceInterface {

    ReportQueryResponse getReportById(String id);

    List<ReportQueryResponse> getAllReports();

    List<ReportQueryResponse> getReportsByCitizenId(String citizenId);

    List<ReportQueryResponse> getReportsByStatus(Status status);

    List<ReportQueryResponse> getReportsByCategoryIssue(CategoryIssue categoryIssue);
}
