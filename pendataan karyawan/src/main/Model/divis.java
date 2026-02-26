package com.employeemanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Divisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaDivisi;

    @OneToMany(mappedBy = "divisi", cascade = CascadeType.ALL)
    private List<Karyawan> karyawan;

    // Getter & Setter
}