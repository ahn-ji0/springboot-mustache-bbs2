package com.mustache.bbspractice2.service;

import com.mustache.bbspractice2.domain.dto.HospitalResponse;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("영업중 테스트")
    void getHospital(){
        Integer id = 3;
        HospitalEntity hospitalEntity = HospitalEntity.builder()
                .id(3)
                .hospitalName("사랑이가득한치과의원")
                .businessStatusCode(13)
                .build();

        Mockito.when(hospitalRepository.findById(id))
                .thenReturn(Optional.of(hospitalEntity));

        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        assertEquals("사랑이가득한치과의원",hospitalResponse.getHospitalName());
        assertEquals("영업중",hospitalResponse.getBusinessStatusName());
    }
    @Test
    @DisplayName("폐업 테스트")
    void getHospital2(){
        Integer id = 3;
        HospitalEntity hospitalEntity = HospitalEntity.builder()
                .id(3)
                .hospitalName("사랑이가득한치과의원")
                .businessStatusCode(3)
                .build();

        Mockito.when(hospitalRepository.findById(id))
                .thenReturn(Optional.of(hospitalEntity));
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        assertEquals("사랑이가득한치과의원",hospitalResponse.getHospitalName());
        assertEquals("폐업",hospitalResponse.getBusinessStatusName());
    }

}