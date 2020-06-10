package stpc.bbs.repositories;

import stpc.bbs.entity.CommentxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentxEntity, Integer> {

    /**
     * 查询对象下的评论
     */
//    @Transactional
    List<CommentxEntity> findAllByObjectIdAndCommentTypeOrderByCreateDateAsc(Integer objectId, String commentType);


    List<CommentxEntity> findAllByCreatorId(String creatorId);



}
