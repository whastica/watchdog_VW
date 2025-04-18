package com.whastica.microservicioReporte.command.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whastica.microservicioReporte.command.domain.model.Report;

@Repository
public interface CommandReportRepository extends JpaRepository<Report, String> {
    // Aquí puedes añadir métodos personalizados si lo necesitas, por ejemplo:
    // List<Report> findByStatus(Status status);
}