package com.employeemanagement.model;

import jakarta.persistence.*;

@Entity
public class Karyawan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String jabatan;

    @ManyToOne
    @JoinColumn(name = "divisi_id")
    private Divisi divisi;

    // Getter & Setter
}