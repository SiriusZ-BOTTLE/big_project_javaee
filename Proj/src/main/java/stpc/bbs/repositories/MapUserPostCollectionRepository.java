package stpc.bbs.repositories;

import stpc.bbs.entity.MapUserPostCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapUserPostCollectionRepository extends JpaRepository<MapUserPostCollectionEntity,Integer> {

    MapUserPostCollectionEntity findByUserIdAndPostId(String userId, Integer postId);

    List<MapUserPostCollectionEntity> findAllByUserId(String userId);

    List<MapUserPostCollectionEntity> findAllByPostId(Integer postId);

}
