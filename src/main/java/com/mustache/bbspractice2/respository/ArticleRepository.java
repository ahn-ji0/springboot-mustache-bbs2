package com.mustache.bbspractice2.respository;

import com.mustache.bbspractice2.domain.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
}
