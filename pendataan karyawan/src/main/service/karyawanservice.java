package com.employeemanagement.service;

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

    public Karyawan saveKaryawan(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

}

public Karyawan getKaryawanById(Long id) {
    return karyawanRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Karyawan dengan ID " + id + " tidak ditemukan"));
}
