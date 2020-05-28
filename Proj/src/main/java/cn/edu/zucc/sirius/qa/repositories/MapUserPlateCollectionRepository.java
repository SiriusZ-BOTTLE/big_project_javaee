package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.MapUserPlateCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapUserPlateCollectionRepository extends JpaRepository<MapUserPlateCollectionEntity, Integer> {

    List<MapUserPlateCollectionEntity> findAllByUserId(String userId);

    MapUserPlateCollectionEntity findByUserIdAndPlateId(String userId, Integer plateId);

}
