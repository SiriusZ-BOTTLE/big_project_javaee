package stpc.bbs.repositories;

import stpc.bbs.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {
    Integer countByCreatorId(String id);
}
