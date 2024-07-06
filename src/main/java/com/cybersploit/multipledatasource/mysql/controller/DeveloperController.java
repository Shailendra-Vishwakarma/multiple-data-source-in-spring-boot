package com.cybersploit.multipledatasource.mysql.controller;

import com.cybersploit.multipledatasource.mysql.entity.Developer;
import com.cybersploit.multipledatasource.mysql.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable int id) {
        Optional<Developer> developer = developerService.getDeveloperById(id);
        return developer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        Developer savedDeveloper = developerService.saveDeveloper(developer);
        return new ResponseEntity<>(savedDeveloper, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Developer> updateDeveloper(@PathVariable int id, @RequestBody Developer developerDetails) {
        Optional<Developer> optionalDeveloper = developerService.getDeveloperById(id);
        if (optionalDeveloper.isPresent()) {
            Developer developer = optionalDeveloper.get();
            developer.setName(developerDetails.getName());
            developer.setProject(developerDetails.getProject());
            Developer updatedDeveloper = developerService.updateDeveloper(developer);
            return ResponseEntity.ok(updatedDeveloper);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable int id) {
        Optional<Developer> developer = developerService.getDeveloperById(id);
        if (developer.isPresent()) {
            developerService.deleteDeveloper(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
