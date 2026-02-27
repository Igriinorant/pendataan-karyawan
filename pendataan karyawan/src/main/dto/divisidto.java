package com.employeemanagement.dto;

public class DivisiDTO {
    private Long id;
    private String namaDivisi;

    // Constructor
    public DivisiDTO() {}
    public DivisiDTO(Long id, String namaDivisi) {
        this.id = id;
        this.namaDivisi = namaDivisi;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNamaDivisi() { return namaDivisi; }
    public void setNamaDivisi(String namaDivisi) { this.namaDivisi = namaDivisi; }
}