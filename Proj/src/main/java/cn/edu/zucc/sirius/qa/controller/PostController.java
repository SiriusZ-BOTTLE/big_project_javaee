package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.entity.CommentxEntity;
import cn.edu.zucc.sirius.qa.entity.ImageEntity;
import cn.edu.zucc.sirius.qa.entity.PostEntity;
import cn.edu.zucc.sirius.qa.formbean.PageQueryRequest;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    public static PostRepository postRepository;

    //构造函数
    public PostController(PostRepository postRepository)
    {
        PostController.postRepository=postRepository;
    }

    /**
     * 创建帖子接口
     * @param postEntity 目标
     * @return
     */
    @PostMapping("/post/create")
    public RequestResult create(@RequestBody PostEntity postEntity)
    {
        RequestResult res=new RequestResult();

        res.setObject(postRepository.save(postEntity));
        res.setSuccess(true);
        return res;
    }

//    /**
//     * 列出近期帖子
//     * 函数被废弃
//     * @return
//     */
//    @PostMapping("/post/list_recent")
//    @Deprecated
//    public RequestResult list_recent(){
//        RequestResult res=new RequestResult();
//
////        res.setObject(postRepository.findAll());
//        res.setObject(postRepository.findAllByOrderByUpdateDateDesc(PageRequest.of(1,20)));
//        res.setSuccess(true);
//        return res;
//    }

    /**
     * 分页查询
     * @return RequestResult
     */
    @PostMapping("/post/page_list")
    public RequestResult page_list(@RequestBody PageQueryRequest pageQueryRequest)
    {
        RequestResult res=new RequestResult();

        res.setObject(postRepository.findAllByOrderByUpdateDateDesc(PageRequest.of(pageQueryRequest.getPageNumber(),pageQueryRequest.getPageSize())));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/post/list_by_content_match")
    public RequestResult list_by_content_match(@RequestParam String content,@RequestBody PageQueryRequest pageQueryRequest)
    {
        RequestResult res=new RequestResult();
        res.setObject(postRepository.findAllByContentMatch(content,PageRequest.of(pageQueryRequest.getPageNumber(),pageQueryRequest.getPageSize())));
        res.setSuccess(true);
        return res;
    }


    @PostMapping("/post/list_under_plate")
    public RequestResult list_under_plate(@RequestParam Integer plateId,@RequestBody PageQueryRequest pageQueryRequest){
        RequestResult res=new RequestResult();

        res.setObject(postRepository.findAllByPlateId(plateId,PageRequest.of(pageQueryRequest.getPageNumber(),pageQueryRequest.getPageSize())));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/post/list_created_by_user")
    public RequestResult list_created_by_user(@RequestParam String creatorId){
        RequestResult res=new RequestResult();

        res.setObject(postRepository.findAllByCreatorId(creatorId));
        res.setSuccess(true);
        return res;
    }


    @PostMapping("/post/get")
    public RequestResult get(@RequestParam Integer postId)
    {
        RequestResult res=new RequestResult();
        res.setObject(postRepository.findByPostId(postId));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/post/delete")
    public RequestResult delete(@RequestParam Integer postId)
    {
        RequestResult res=new RequestResult();
        //获取图片列表
        List<ImageEntity> il=ImageController.imageRepository.findAllByObjectIdAndImageType(postId,"post");

        for(ImageEntity e:il)//遍历删除全部图片
        {
            RequestResult r = FileController.delete(e.getImageUrl());
        }
        //删除全部评论
        List<CommentxEntity> cl=CommentController.commentRepository.findAllByObjectIdAndCommentTypeOrderByCreateDateAsc(postId,"post");
        CommentController.commentRepository.deleteAll(cl);

        postRepository.deleteById(postId);
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/post/list_user_collection")
    public RequestResult list_user_collection(@RequestParam String userId)
    {
        RequestResult res=new RequestResult();

        res.setObject(postRepository.findUserPostCollection(userId));
        res.setSuccess(true);
        return res;
    }


}
