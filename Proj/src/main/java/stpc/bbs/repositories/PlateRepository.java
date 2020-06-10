package stpc.bbs.repositories;

import stpc.bbs.entity.PlateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlateRepository extends JpaRepository<PlateEntity, Integer> {

    List<PlateEntity> findAllByActivated(Byte activated);

    /**
     * 查询用户订阅的全部板块(返回对象)
     * @param userId 目标用户的ID
     * @return 列表
     */
    @Query
    (
        nativeQuery = true,
        value="select * from plate where plate_id in (select plate_id from map_user_plate_collection where user_id = :userId)"
    )
    List<PlateEntity> findUserSubscription(@Param("userId") String userId);

    /**
     * 查询信息
     * @param plateId 主键
     * @return 对象
     */
    PlateEntity findByPlateId(Integer plateId);


}
