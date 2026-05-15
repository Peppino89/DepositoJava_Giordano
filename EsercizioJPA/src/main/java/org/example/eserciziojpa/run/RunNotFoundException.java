package org.example.eserciziojpa.run;

public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(Integer id) {
        super("Run con id "+id+" non trovato");
    }
}
