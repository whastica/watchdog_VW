package com.whastica.microservicioReporte.query.domain.repository;

import com.whastica.microservicioReporte.query.domain.model.ReportQuery;
import com.whastica.microservicioReporte.shared.model.CategoryIssue;
import com.whastica.microservicioReporte.shared.model.Status;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReportQueryRepository extends MongoRepository<ReportQuery, String> {

    List<ReportQuery> findByCitizenId(String citizenId);

    List<ReportQuery> findByStatus(Status status);

    List<ReportQuery> findByCategoryIssue(CategoryIssue categoryIssue);
}