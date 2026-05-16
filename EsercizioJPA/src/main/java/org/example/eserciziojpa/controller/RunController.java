package org.example.eserciziojpa.controller;

import jakarta.validation.Valid;
import org.example.eserciziojpa.dto.RunRequest;
import org.example.eserciziojpa.dto.RunResponse;
import org.example.eserciziojpa.service.RunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(runService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunResponse> findById(@PathVariable Integer id) {
        RunResponse response = runService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RunResponse> create(@Valid @RequestBody RunRequest request) {
        RunResponse response = runService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunResponse> update(
            @PathVariable Integer id,
            @Valid @RequestBody RunRequest request
    ) {
        RunResponse response = runService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RunResponse> delete(@PathVariable Integer id) {
        RunResponse deletedRun = runService.deleteById(id);
        return ResponseEntity.ok(deletedRun);
    }
}