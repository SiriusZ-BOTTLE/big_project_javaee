package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.MapUserUserFollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapUserUserFollowingRepository extends JpaRepository<MapUserUserFollowingEntity, Integer> {
    //统计用户关注的人数
    Integer countByUserId0(String id);
    //统计关注了该用户的人数
    Integer countByUserId1(String id);
}
