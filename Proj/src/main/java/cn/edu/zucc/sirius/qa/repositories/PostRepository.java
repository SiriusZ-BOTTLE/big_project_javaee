package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {



}
