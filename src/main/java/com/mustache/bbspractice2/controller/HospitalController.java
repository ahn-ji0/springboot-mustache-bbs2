package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/list")
    public String listAll(Model model){
        List<HospitalEntity> hospitals = hospitalRepository.findAll();
        model.addAttribute("hospitals",hospitals);
        return "hospitals/list";
    }
}
