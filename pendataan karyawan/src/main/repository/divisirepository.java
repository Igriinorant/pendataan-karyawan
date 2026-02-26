package com.employeemanagement.repository;

import com.employeemanagement.model.Divisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisiRepository extends JpaRepository<Divisi, Long> {
}