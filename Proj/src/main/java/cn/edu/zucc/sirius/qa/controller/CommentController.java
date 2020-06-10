package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.entity.CommentxEntity;
import cn.edu.zucc.sirius.qa.entity.PostEntity;
import cn.edu.zucc.sirius.qa.formbean.CommentListRequest;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.CommentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CommentController {

    public static CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository){
        CommentController.commentRepository=commentRepository;
    }

    @PostMapping("/comment/create")
    public RequestResult create(@RequestBody CommentxEntity commentxEntity){
        RequestResult res=new RequestResult();

        CommentxEntity ce=commentRepository.save(commentxEntity);
        res.setObject(ce);

        //更新帖子的更新日期
        if(commentxEntity.getCommentType().equals("post"))
        {
            PostEntity pe=PostController.postRepository.findByPostId(commentxEntity.getObjectId());
            pe.setUpdateDate(ce.getCreateDate());
            PostController.postRepository.save(pe);
        }

        res.setSuccess(true);
        return res;
    }

    @PostMapping("/comment/list")
    public RequestResult list(@RequestBody CommentListRequest commentListRequest){
        RequestResult res=new RequestResult();
        res.setObject(commentRepository.findAllByObjectIdAndCommentTypeOrderByCreateDateAsc(commentListRequest.getObjectId(),commentListRequest.getCommentType()));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/comment/list_created_by_user")
    public RequestResult list_created_by_user(@RequestParam String userId){
        RequestResult res=new RequestResult();
        res.setObject(commentRepository.findAllByCreatorId(userId));
        res.setSuccess(true);
        return res;
    }


}
