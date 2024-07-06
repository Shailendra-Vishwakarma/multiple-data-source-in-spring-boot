package com.cybersploit.multipledatasource.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tester")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String project;
}
