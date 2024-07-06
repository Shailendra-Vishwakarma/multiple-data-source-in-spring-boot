package com.cybersploit.multipledatasource.mysql.respository;

import com.cybersploit.multipledatasource.mysql.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRespository extends JpaRepository<Developer,Integer> {
}
