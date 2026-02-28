package com.employeemanagement.service;

import com.employeemanagement.exception.ResourceNotFoundException;
import com.employeemanagement.model.Karyawan;
import com.employeemanagement.repository.KaryawanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KaryawanService {
    private final KaryawanRepository karyawanRepository;

    public KaryawanService(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    public List<Karyawan> getAllKaryawan() {
        return karyawanRepository.findAll();
    }

    public Karyawan getKaryawanById(Long id) {
        return karyawanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Karyawan dengan ID " + id + " tidak ditemukan"));
    }

    public Karyawan saveKaryawan(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    public Karyawan updateKaryawan(Long id, Karyawan newData) {
        Karyawan existing = getKaryawanById(id);
        existing.setNama(newData.getNama());
        existing.setJabatan(newData.getJabatan());
        existing.setDivisi(newData.getDivisi());
        return karyawanRepository.save(existing);
    }

    public void deleteKaryawan(Long id) {
        Karyawan existing = getKaryawanById(id);
        karyawanRepository.delete(existing);
    }

    // Search & Filter
    public List<Karyawan> searchByNama(String nama) {
        return karyawanRepository.findByNamaContainingIgnoreCase(nama);
    }

    public List<Karyawan> filterByJabatan(String jabatan) {
        return karyawanRepository.findByJabatan(jabatan);
    }

    public List<Karyawan> filterByDivisi(Long divisiId) {
        return karyawanRepository.findByDivisiId(divisiId);
    }
}
