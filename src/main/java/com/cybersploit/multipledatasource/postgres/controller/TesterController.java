package com.cybersploit.multipledatasource.postgres.controller;

import com.cybersploit.multipledatasource.postgres.entity.Tester;
import com.cybersploit.multipledatasource.postgres.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testers")
public class TesterController {

    @Autowired
    private TesterService testerService;

    @GetMapping
    public List<Tester> getAllTesters() {
        return testerService.getAllTesters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tester> getTesterById(@PathVariable int id) {
        Optional<Tester> tester = testerService.getTesterById(id);
        return tester.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tester> createTester(@RequestBody Tester tester) {
        Tester savedTester = testerService.saveTester(tester);
        return new ResponseEntity<>(savedTester, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tester> updateTester(@PathVariable int id, @RequestBody Tester testerDetails) {
        Optional<Tester> optionalTester = testerService.getTesterById(id);
        if (optionalTester.isPresent()) {
            Tester tester = optionalTester.get();
            tester.setName(testerDetails.getName());
            tester.setProject(testerDetails.getProject());
            Tester updatedTester = testerService.updateTester(tester);
            return ResponseEntity.ok(updatedTester);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTester(@PathVariable int id) {
        Optional<Tester> tester = testerService.getTesterById(id);
        if (tester.isPresent()) {
            testerService.deleteTester(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
