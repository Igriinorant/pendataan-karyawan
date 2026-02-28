package com.employeemanagement.repository;

import com.employeemanagement.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {
    List<Karyawan> findByNamaContainingIgnoreCase(String nama);
    List<Karyawan> findByJabatan(String jabatan);
    List<Karyawan> findByDivisiId(Long divisiId);
}
