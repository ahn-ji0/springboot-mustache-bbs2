package com.mustache.bbspractice2.service;

import com.mustache.bbspractice2.domain.dto.HospitalResponse;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void setUp(){
        //가짜 객체가 들어간 hospital service
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    void getHospital(){
        Integer id = 3;
        HospitalEntity hospitalEntity = new HospitalEntity(3,"광주광역시 북구 설죽로 495, 3층 (일곡동)","사랑이가득한치과의원","치과의원",0,13);
        Mockito.when(hospitalRepository.findById(id))
                .thenReturn(Optional.of(hospitalEntity));

        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        assertEquals("사랑이가득한치과의원",hospitalResponse.getHospitalName());
        assertEquals("영업중",hospitalResponse.getBusinessStatusName());

    }

}