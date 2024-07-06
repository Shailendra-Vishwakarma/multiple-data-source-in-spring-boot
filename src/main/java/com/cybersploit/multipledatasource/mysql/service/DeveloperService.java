package com.cybersploit.multipledatasource.mysql.service;

import com.cybersploit.multipledatasource.mysql.entity.Developer;
import com.cybersploit.multipledatasource.mysql.respository.DeveloperRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRespository developerRepository;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Optional<Developer> getDeveloperById(int id) {
        return developerRepository.findById(id);
    }

    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer updateDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public void deleteDeveloper(int id) {
        developerRepository.deleteById(id);
    }
}

