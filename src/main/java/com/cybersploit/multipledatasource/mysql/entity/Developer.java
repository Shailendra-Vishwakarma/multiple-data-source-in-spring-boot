package com.cybersploit.multipledatasource.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="developer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String project;
}
