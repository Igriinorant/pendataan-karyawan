package com.employeemanagement.repository;

import com.employeemanagement.model.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface karyawanrepository extends JpaRepository<Karyawan, Long> {
}