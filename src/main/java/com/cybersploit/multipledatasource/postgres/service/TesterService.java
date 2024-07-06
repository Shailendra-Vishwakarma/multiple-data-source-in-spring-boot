package com.cybersploit.multipledatasource.postgres.service;

import com.cybersploit.multipledatasource.postgres.entity.Tester;
import com.cybersploit.multipledatasource.postgres.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TesterService {

    @Autowired
    private TesterRepository testerRepository;

    public List<Tester> getAllTesters() {
        return testerRepository.findAll();
    }

    public Optional<Tester> getTesterById(int id) {
        return testerRepository.findById(id);
    }

    public Tester saveTester(Tester tester) {
        return testerRepository.save(tester);
    }

    public Tester updateTester(Tester tester) {
        return testerRepository.save(tester);
    }

    public void deleteTester(int id) {
        testerRepository.deleteById(id);
    }
}
