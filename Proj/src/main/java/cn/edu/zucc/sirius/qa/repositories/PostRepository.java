package cn.edu.zucc.sirius.qa.repositories;

import cn.edu.zucc.sirius.qa.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    /**
     * 不使用的函数, 现在改为分页查询
     * @return 列表
     */
    @Deprecated
    List<PostEntity> findAllByOrderByUpdateDateDesc();

    /**
     * 不使用的函数, 现在改为分页查询
     * @param plateId
     * @return
     */
    @Deprecated
    List<PostEntity> findAllByPlateId(Integer plateId);

    /**
     * 分页查询的版本
     * @param plateId
     * @param pageable
     * @return
     */
    Page<PostEntity> findAllByPlateId(Integer plateId,Pageable pageable);

    List<PostEntity> findAllByCreatorId(String creatorId);

    PostEntity findByPostId(Integer postId);

    /**
     * 查询用户收藏的全部帖子(返回对象)
     * @param userId 目标用户的ID
     * @return 列表
     */
    @Query
    (
        nativeQuery = true,
        value="select * from post where post_id in (select post_id from map_user_post_collection where user_id = :userId)"
    )
    List<PostEntity> findUserPostCollection(@Param("userId") String userId);

    /**
     * 分页查询全部
     * @param pageable
     * @return
     */
    Page<PostEntity> findAllByOrderByUpdateDateDesc(Pageable pageable);

    /**
     * 全文索引模糊查询
     * @param pageable
     * @return
     */
    @Query
    (
        nativeQuery = true,
        value="SELECT * FROM post WHERE MATCH (post_title,post_content) AGAINST (:content IN NATURAL LANGUAGE MODE)"
    )
    Page<PostEntity> findAllByContentMatch(@Param("content") String content,Pageable pageable);

    /**
     * 获取用户发帖数
     * @param creatorId 用户id
     * @return 数字
     */
    Integer countByCreatorId(String creatorId);

}
