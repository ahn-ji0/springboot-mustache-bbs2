package com.mustache.bbspractice2.respository;

import com.mustache.bbspractice2.domain.entity.HospitalEntity;
import com.mustache.bbspractice2.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
