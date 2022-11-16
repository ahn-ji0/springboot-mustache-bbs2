package com.mustache.bbspractice2.service;

import com.mustache.bbspractice2.domain.dto.HospitalResponse;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.respository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public HospitalResponse getHospital(Integer id){
        Optional<HospitalEntity> optionalHospital = hospitalRepository.findById(id);
        HospitalEntity hospitalEntity = optionalHospital.get();
        HospitalResponse hospitalResponse = HospitalEntity.of(hospitalEntity);
        if(hospitalEntity.getBusinessStatusCode() == 13){
            hospitalResponse.setBusinessStatusName("영업중");
        }
        else if(hospitalEntity.getBusinessStatusCode()==3){
            hospitalResponse.setBusinessStatusName("폐업");
        }
        else hospitalResponse.setBusinessStatusName(String.valueOf(hospitalEntity.getBusinessStatusCode()));

        return hospitalResponse;
    }
}
