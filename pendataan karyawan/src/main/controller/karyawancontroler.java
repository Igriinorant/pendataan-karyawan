package com.employeemanagement.controller;

import com.employeemanagement.dto.KaryawanDTO;
import com.employeemanagement.model.Divisi;
import com.employeemanagement.model.Karyawan;
import com.employeemanagement.service.KaryawanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
    private final KaryawanService karyawanService;

    public KaryawanController(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    // GET all
    @GetMapping
    public List<KaryawanDTO> getAllKaryawan() {
        return karyawanService.getAllKaryawan().stream()
                .map(k -> new KaryawanDTO(k.getId(), k.getNama(), k.getJabatan(), k.getDivisi().getId()))
                .collect(Collectors.toList());
    }

    // GET by ID
    @GetMapping("/{id}")
    public KaryawanDTO getKaryawanById(@PathVariable Long id) {
        Karyawan k = karyawanService.getKaryawanById(id);
        return new KaryawanDTO(k.getId(), k.getNama(), k.getJabatan(), k.getDivisi().getId());
    }

    // CREATE
    @PostMapping
    public KaryawanDTO createKaryawan(@RequestBody KaryawanDTO dto) {
        Karyawan karyawan = new Karyawan();
        karyawan.setNama(dto.getNama());
        karyawan.setJabatan(dto.getJabatan());
        Divisi divisi = new Divisi();
        divisi.setId(dto.getDivisiId());
        karyawan.setDivisi(divisi);

        Karyawan saved = karyawanService.saveKaryawan(karyawan);
        return new KaryawanDTO(saved.getId(), saved.getNama(), saved.getJabatan(), saved.getDivisi().getId());
    }

    // UPDATE
    @PutMapping("/{id}")
    public KaryawanDTO updateKaryawan(@PathVariable Long id, @RequestBody KaryawanDTO dto) {
        Karyawan newData = new Karyawan();
        newData.setNama(dto.getNama());
        newData.setJabatan(dto.getJabatan());
        Divisi divisi = new Divisi();
        divisi.setId(dto.getDivisiId());
        newData.setDivisi(divisi);

        Karyawan updated = karyawanService.updateKaryawan(id, newData);
        return new KaryawanDTO(updated.getId(), updated.getNama(), updated.getJabatan(), updated.getDivisi().getId());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteKaryawan(@PathVariable Long id) {
        karyawanService.deleteKaryawan(id);
        return "Karyawan dengan ID " + id + " berhasil dihapus";
    }

    // SEARCH & FILTER
    @GetMapping("/search")
    public List<KaryawanDTO> searchByNama(@RequestParam String nama) {
        return karyawanService.searchByNama(nama).stream()
                .map(k -> new KaryawanDTO(k.getId(), k.getNama(), k.getJabatan(), k.getDivisi().getId()))
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/jabatan")
    public List<KaryawanDTO> filterByJabatan(@RequestParam String jabatan) {
        return karyawanService.filterByJabatan(jabatan).stream()
                .map(k -> new KaryawanDTO(k.getId(), k.getNama(), k.getJabatan(), k.getDivisi().getId()))
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/divisi")
    public List<KaryawanDTO> filterByDivisi(@RequestParam Long divisiId) {
        return karyawanService.filterByDivisi(divisiId).stream()
                .map(k -> new KaryawanDTO(k.getId(), k.getNama(), k.getJabatan(), k.getDivisi().getId()))
                .collect(Collectors.toList());
    }
}
