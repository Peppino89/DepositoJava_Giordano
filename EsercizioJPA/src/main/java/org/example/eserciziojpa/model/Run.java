package org.example.eserciziojpa.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "runs")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "started_on", nullable = false)
    private LocalDateTime startedOn;

    @Column(name = "completed_on", nullable = false)
    private LocalDateTime completedOn;

    @Column(name = "miles", nullable = false)
    private double miles;

    @Enumerated(EnumType.STRING)  // salva il nome dell'enum come stringa ("INDOOR"/"OUTDOOR")
    @Column(name = "location", nullable = false)
    private Location location;

    // ── Costruttore no-arg richiesto da JPA ──────────────────────────────────
    protected Run() {}

    // ── Costruttore completo per uso applicativo ─────────────────────────────
    public Run(String title, LocalDateTime startedOn, LocalDateTime completedOn,
               double miles, Location location) {
        if (miles < 0) throw new IllegalArgumentException("Le miglia non possono essere negative");
        if (completedOn.isBefore(startedOn)) throw new IllegalArgumentException("La data di fine deve essere dopo quella di inizio");
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
    }

    // ── Getter ───────────────────────────────────────────────────────────────
    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public LocalDateTime getStartedOn() { return startedOn; }
    public LocalDateTime getCompletedOn() { return completedOn; }
    public double getMiles() { return miles; }
    public Location getLocation() { return location; }

    // ── Setter ───────────────────────────────────────────────────────────────
    public void setTitle(String title) { this.title = title; }
    public void setStartedOn(LocalDateTime startedOn) { this.startedOn = startedOn; }
    public void setCompletedOn(LocalDateTime completedOn) { this.completedOn = completedOn; }
    public void setMiles(double miles) { this.miles = miles; }
    public void setLocation(Location location) { this.location = location; }

    // ── toString ─────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Run{id=" + id + ", title='" + title + "', miles=" + miles + ", location=" + location + "}";
    }
}