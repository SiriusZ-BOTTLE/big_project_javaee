package cn.edu.zucc.pb.qa.repositories;

import cn.edu.zucc.pb.qa.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
    Integer countByCreatorId(String id);
}
