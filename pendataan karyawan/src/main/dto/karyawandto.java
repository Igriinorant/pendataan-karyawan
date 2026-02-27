package com.employeemanagement.dto;

public class KaryawanDTO {
    private Long id;
    private String nama;
    private String jabatan;
    private Long divisiId;

    // Constructor
    public KaryawanDTO() {}
    public KaryawanDTO(Long id, String nama, String jabatan, Long divisiId) {
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.divisiId = divisiId;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
    public Long getDivisiId() { return divisiId; }
    public void setDivisiId(Long divisiId) { this.divisiId = divisiId; }
}