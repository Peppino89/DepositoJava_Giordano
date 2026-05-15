package org.example.eserciziojpa.service;


import org.example.eserciziojpa.model.Run;
import org.example.eserciziojpa.repository.RunRepository;
import org.example.eserciziojpa.run.RunNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RunService {

    private final RunRepository runRepository;

    // Iniezione via costruttore (raccomandata)
    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public List<Run> findAll() {
        return runRepository.findAll();
    }

    public Run findById(Integer id) {

        return runRepository.findById(id)
                .orElseThrow(()->new RunNotFoundException(id));
    }

    public Run save(Run run) {
        return runRepository.save(run);
    }

    public void deleteById(Integer id) {
        if(!runRepository.existsById(id)) {
            throw new RunNotFoundException(id);
        }
        runRepository.deleteById(id);
    }

    public Run update(Integer id, Run updatedRun) {
        Optional<Run> existing = runRepository.findById(id);
        if(existing.isEmpty()){
            return null;
        }

        Run run = existing.get();
        run.setTitle(updatedRun.getTitle());
        run.setStartedOn(updatedRun.getStartedOn());
        run.setCompletedOn(updatedRun.getCompletedOn());
        run.setMiles(updatedRun.getMiles());
        run.setLocation(updatedRun.getLocation());

        return runRepository.save(run);
    }
}
