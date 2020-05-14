package cn.edu.zucc.pb.qa.repositories;

import cn.edu.zucc.pb.qa.entity.UserxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserxRepository extends JpaRepository<UserxEntity, Integer> {
    UserxEntity findByUserId(String id);

}
