package com.mustache.bbspractice2.respository;

import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("buisness type이 보건소 보건지소 보건진료소인 데이터 잘 나오는지")
    void findByBuisnessTypeNameIn(){
        List<String> includes = new ArrayList<>();
        includes.add("보건소");
        includes.add("보건지소");
        includes.add("보건진료소");
        List<HospitalEntity> hospitals = hospitalRepository.findByBusinessTypeNameIn(includes);
        for(var hospital : hospitals){
            System.out.println(hospital.getHospitalName());
        }
    }
}