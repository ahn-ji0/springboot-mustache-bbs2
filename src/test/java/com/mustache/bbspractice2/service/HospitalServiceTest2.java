package com.mustache.bbspractice2.service;

import com.mustache.bbspractice2.domain.dto.HospitalResponse;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospitalServiceTest2 {

    HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    HospitalService hospitalService;

    @BeforeEach
    void setUp(){
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("getHospital 테스트")
    void getHospital() {
        Integer id = 1;
        HospitalEntity hospitalEntity = HospitalEntity.builder()
                .id(id)
                .hospitalName("세브란스병원")
                .businessStatusCode(13)
                .build();
        Mockito.when(hospitalRepository.findById(id))
                .thenReturn(Optional.of(hospitalEntity));

        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        assertEquals(1,hospitalResponse.getId());
        assertEquals("영업중",hospitalResponse.getBusinessStatusName());
    }
}
