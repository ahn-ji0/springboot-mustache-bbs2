package com.mustache.bbspractice2.respository;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import com.mustache.bbspractice2.domain.entity.CommentEntity;
import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<HospitalEntity,Integer> {
    List<HospitalEntity> findByHospitalName(String hospitalName);

}
