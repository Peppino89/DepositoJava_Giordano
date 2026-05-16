package org.example.eserciziojpa.dto;

import org.example.eserciziojpa.model.Location;

import java.time.LocalDateTime;

public record RunResponse(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
) {}