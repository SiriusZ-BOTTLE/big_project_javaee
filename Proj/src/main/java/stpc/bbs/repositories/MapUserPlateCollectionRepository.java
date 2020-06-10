package stpc.bbs.repositories;

import stpc.bbs.entity.MapUserPlateCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapUserPlateCollectionRepository extends JpaRepository<MapUserPlateCollectionEntity, Integer> {

    List<MapUserPlateCollectionEntity> findAllByUserId(String userId);

    MapUserPlateCollectionEntity findByUserIdAndPlateId(String userId, Integer plateId);

}
