package com.mustache.bbspractice2.respository;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import com.mustache.bbspractice2.domain.entity.CommentEntity;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospitalRepository extends JpaRepository<HospitalEntity,Integer> {
    List<HospitalEntity> findByBusinessTypeNameIn(List<String> businessTypes);
    List<HospitalEntity> findByRoadNameAddressContaining(String type);
    List<HospitalEntity> findByHospitalNameStartsWith(String start);
    List<HospitalEntity> findByHospitalNameEndsWith(String end);
    List<HospitalEntity> findByTotalNumberOfBedsBetween(int min, int max);
}
