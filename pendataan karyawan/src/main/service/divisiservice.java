package com.employeemanagement.service;

import com.employeemanagement.model.Divisi;
import com.employeemanagement.repository.DivisiRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DivisiService {
    private final DivisiRepository divisiRepository;

    public DivisiService(DivisiRepository divisiRepository) {
        this.divisiRepository = divisiRepository;
    }

    public List<Divisi> getAllDivisi() {
        return divisiRepository.findAll();
    }

    public Divisi saveDivisi(Divisi divisi) {
        return divisiRepository.save(divisi);
    }
}