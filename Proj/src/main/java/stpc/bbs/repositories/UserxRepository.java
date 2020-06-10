package stpc.bbs.repositories;

import stpc.bbs.entity.UserxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserxRepository extends JpaRepository<UserxEntity, Integer> {
    UserxEntity findByUserId(String id);

}
