package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.entity.PostEntity;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.PostRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 列出近期帖子
     * @return
     */
    @PostMapping("/post/list_recent")
    public RequestResult listRecent(){
        RequestResult res=new RequestResult();

//        res.setObject(postRepository.findAll());
        res.setObject(postRepository.findAllByOrderByUpdateDateDesc());
        res.setSuccess(true);
        return res;
    }


}
