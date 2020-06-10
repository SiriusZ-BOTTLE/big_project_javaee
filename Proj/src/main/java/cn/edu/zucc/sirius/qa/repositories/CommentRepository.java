package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.CommentxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentxEntity, Integer> {

    /**
     * 查询对象下的评论
     */
//    @Transactional
    List<CommentxEntity> findAllByObjectIdAndCommentTypeOrderByCreateDateAsc(Integer objectId, String commentType);


    List<CommentxEntity> findAllByCreatorId(String creatorId);



}
