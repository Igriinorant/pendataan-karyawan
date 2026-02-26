package com.employeemanagement.controller;

import com.employeemanagement.model.Karyawan;
import com.employeemanagement.service.KaryawanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
    private final KaryawanService karyawanService;

    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    @GetMapping
    public List<Karyawan> getAllKaryawan() {
        return karyawanService.getAllKaryawan();
    }

    @PostMapping
    public Karyawan createKaryawan(@RequestBody Karyawan karyawan) {
        return karyawanService.saveKaryawan(karyawan);
    }
}