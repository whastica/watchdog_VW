package com.whastica.microservicioReporte.shared.model;

public enum Status {
    EN_LISTA("En lista de espera"),
    EN_REVISION("En revisión"),
    EN_PROCESO("En proceso de solución"),
    RESUELTO("Resuelto");

    private final String descripcion;

    Status(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}