package org.example.eserciziojpa.run;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        int status,
        LocalDateTime timeStamp
) {}
