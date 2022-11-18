package com.mustache.bbspractice2.controller;

import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("")
    public String listAll(@RequestParam(required = false) String keyword, Model model, @PageableDefault(size = 20, sort="id",direction=Sort.Direction.ASC) Pageable pageable){
        log.info(keyword);
        Page<HospitalEntity> hospitals = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
        //log.info(hospitals.getPageable().toString()); = Page request [number: 0, size 20, sort: id: ASC]
        //log.info(String.valueOf(hospitals.getNumberOfElements())); = 20
        //log.info(String.valueOf(hospitals.getTotalPages())); = 4951
        model.addAttribute("hospitals",hospitals.getContent());
        model.addAttribute("previousPage", hospitals.previousOrFirstPageable().getPageNumber());
        model.addAttribute("nextPage",hospitals.nextOrLastPageable().getPageNumber());
        model.addAttribute("keyword",keyword);
        return "hospitals/list";
    }

}
