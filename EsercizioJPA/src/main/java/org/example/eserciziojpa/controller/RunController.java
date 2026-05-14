package org.example.eserciziojpa.controller;

import org.example.eserciziojpa.model.Run;
import org.example.eserciziojpa.repository.RunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    @Autowired// Iniezione via costruttore (raccomandata)
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // GET /api/runs → lista tutte le corse
    @GetMapping
    public List<Run> findAll() {
        return runRepository.findAll();
    }

    // GET /api/runs/{id} → singola corsa
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        return run.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/runs → crea nuova corsa
    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run run) {
        Run saved = runRepository.save(run);
        return ResponseEntity.status(201).body(saved);
    }

    // PUT /api/runs/{id} → aggiorna corsa esistente
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run runDetails) {
        Optional<Run> existing = runRepository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Run run = existing.get();
        run.setTitle(runDetails.getTitle());
        run.setStartedOn(runDetails.getStartedOn());
        run.setCompletedOn(runDetails.getCompletedOn());
        run.setMiles(runDetails.getMiles());
        run.setLocation(runDetails.getLocation());
        Run updated = runRepository.save(run);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/runs/{id} → elimina corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!runRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        runRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
