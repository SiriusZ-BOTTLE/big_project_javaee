package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.MapUserPostCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapUserPostCollectionRepository extends JpaRepository<MapUserPostCollectionEntity,Integer> {

    MapUserPostCollectionEntity findByUserIdAndPostId(String userId, Integer postId);

    List<MapUserPostCollectionEntity> findAllByUserId(String userId);

}
