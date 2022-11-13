package com.mustache.bbspractice2.respository;

import com.mustache.bbspractice2.domain.entity.ArticleEntity;
import com.mustache.bbspractice2.domain.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
    List<CommentEntity> findAllByArticleEntity(ArticleEntity articleEntity);
}
