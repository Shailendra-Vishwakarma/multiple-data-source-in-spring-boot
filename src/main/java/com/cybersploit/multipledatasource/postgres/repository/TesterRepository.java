package com.cybersploit.multipledatasource.postgres.repository;

import com.cybersploit.multipledatasource.postgres.entity.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesterRepository extends JpaRepository<Tester,Integer> {
}