package org.example.eserciziorunnercontrollercompleto.controller;

import org.example.eserciziorunnercontrollercompleto.model.Location;
import org.example.eserciziorunnercontrollercompleto.model.Run;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    // Lista in memoria (simula un database)
    private final List<Run> runs = new ArrayList<>();

    // Dati iniziali caricati nel costruttore
    public RunController() {

        runs.add(new Run(
                1,
                "Corsa mattutina",
                LocalDateTime.now().minusHours(2),
                LocalDateTime.now().minusHours(1),
                5.5,
                Location.OUTDOOR
        ));

        runs.add(new Run(
                2,
                "Corsa sul tapis roulant",
                LocalDateTime.now().minusDays(1).minusMinutes(40),
                LocalDateTime.now().minusDays(1),
                3.2,
                Location.INDOOR
        ));

        runs.add(new Run(
                3,
                "Corsa pomeridiana",
                LocalDateTime.now().minusDays(1).minusMinutes(40),
                LocalDateTime.now().minusDays(1),
                3.2,
                Location.OUTDOOR
        ));
    }




    // GET /api/runs → lista di tutte le corse
    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        return ResponseEntity.ok(runs);
    }

    // GET /api/runs/{id} → singola corsa per ID
    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {

        if(id<0 || id>=runs.size()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(runs.get(id));
    }

    // POST /api/runs → crea una nuova corsa
    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run newRun) {
      runs.add(newRun);
      return ResponseEntity.status(HttpStatus.CREATED).body(newRun);
    }

    // PUT /api/runs/{id} → aggiorna una corsa esistente
    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run updatedRun) {

        runs.set(id,updatedRun);
             return ResponseEntity.ok(updatedRun);
    }

    // DELETE /api/runs/{id} → elimina una corsa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if(id<0 || id>=runs.size()) {
            return ResponseEntity.notFound().build();
        }
        runs.remove((int)id);
        return ResponseEntity.noContent().build();

    }
}