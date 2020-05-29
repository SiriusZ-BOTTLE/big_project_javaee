package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {

    /**
     * 查询对象下的图片
     * @param objectId 对象id
     * @param imageType 图片类型(对象类型)
     * @return
     */
    List<ImageEntity> findAllByObjectIdAndImageType(Integer objectId, String imageType);


}
