package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.PlateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlateRepository extends JpaRepository<PlateEntity, Integer> {

    List<PlateEntity> findAllByActivated(Byte activated);

}
