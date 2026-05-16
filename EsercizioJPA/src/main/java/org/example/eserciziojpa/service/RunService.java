package org.example.eserciziojpa.service;

import org.example.eserciziojpa.dto.RunRequest;
import org.example.eserciziojpa.dto.RunResponse;
import org.example.eserciziojpa.model.Run;
import org.example.eserciziojpa.repository.RunRepository;
import org.example.eserciziojpa.run.RunNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunService {

    private final RunRepository runRepository;

    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public List<RunResponse> findAll() {
        return runRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public RunResponse findById(Integer id) {
        Run run = runRepository.findById(id)
                .orElseThrow(() -> new RunNotFoundException(id));

        return toResponse(run);
    }

    public RunResponse save(RunRequest request) {
        Run run = toEntity(request);

        Run savedRun = runRepository.save(run);

        return toResponse(savedRun);
    }

    public RunResponse update(Integer id, RunRequest request) {
        Run run = runRepository.findById(id)
                .orElseThrow(() -> new RunNotFoundException(id));

        run.setTitle(request.title());
        run.setStartedOn(request.startedOn());
        run.setCompletedOn(request.completedOn());
        run.setMiles(request.miles());
        run.setLocation(request.location());

        Run updatedRun = runRepository.save(run);

        return toResponse(updatedRun);
    }

    public RunResponse deleteById(Integer id) {
        Run run = runRepository.findById(id)
                .orElseThrow(() -> new RunNotFoundException(id));

        runRepository.delete(run);

        return toResponse(run);
    }

    private Run toEntity(RunRequest request) {
        return new Run(
                request.title(),
                request.startedOn(),
                request.completedOn(),
                request.miles(),
                request.location()
        );
    }

    private RunResponse toResponse(Run run) {
        return new RunResponse(
                run.getId(),
                run.getTitle(),
                run.getStartedOn(),
                run.getCompletedOn(),
                run.getMiles(),
                run.getLocation()
        );
    }
}