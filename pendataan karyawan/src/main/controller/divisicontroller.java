package com.employeemanagement.controller;

import com.employeemanagement.model.Divisi;
import com.employeemanagement.service.DivisiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisi")
public class DivisiController {
    private final DivisiService divisiService;

    public DivisiController(DivisiService divisiService) {
        this.divisiService = divisiService;
    }

    @GetMapping
    public List<Divisi> getAllDivisi() {
        return divisiService.getAllDivisi();
    }

    @PostMapping
    public Divisi createDivisi(@RequestBody Divisi divisi) {
        return divisiService.saveDivisi(divisi);
    }
}