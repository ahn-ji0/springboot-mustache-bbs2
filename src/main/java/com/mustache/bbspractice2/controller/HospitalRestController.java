package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.dto.HospitalResponse;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import com.mustache.bbspractice2.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {
    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }
}