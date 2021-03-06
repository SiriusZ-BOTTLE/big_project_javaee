package stpc.bbs.controller;

import stpc.bbs.entity.UserxEntity;
import stpc.bbs.formbean.Login;
import stpc.bbs.formbean.RequestResult;
import stpc.bbs.formbean.UserxStatistics;
import stpc.bbs.repositories.UserxRepository;
import org.springframework.web.bind.annotation.*;

/**
 *
 */

@RestController
@CrossOrigin
public class UserxController {

    public static UserxRepository repository;

    //构造函数
    public UserxController(UserxRepository repository) {
        UserxController.repository = repository;
    }

    @PostMapping("/user/login")
    RequestResult login(@RequestBody Login login)
    {
        RequestResult res=new RequestResult();
        UserxEntity user=repository.findByUserId(login.getUserId());//获取对象
        if(user==null)//没找到
        {
            res.setMsg("用户ID或密码错误");//用户未找到
            return res;
        }
        else
        {
            if(!login.getUserPwd().equals(user.getUserPwd()))
            {
                res.setMsg("用户ID或密码错误");//密码不匹配
                return res;
            }
            else
            {
                res.setSuccess(true);
                res.setObject(user);
                return res;
            }
        }
    }

    @PostMapping("/user/register")
    RequestResult register(@RequestBody UserxEntity user)
    {
        RequestResult res=new RequestResult();

        if(repository.findByUserId(user.getUserId())!=null)
        {
            res.setSuccess(false);
            res.setMsg("用户ID已经被使用");
            return res;
        }
        UserxEntity userxEntity=repository.save(user);
        res.setSuccess(true);
        res.setObject(userxEntity);
        return res;
    }

    @PostMapping("/user/update")
    RequestResult update(@RequestBody UserxEntity user)
    {
        RequestResult res=new RequestResult();

        UserxEntity userxEntity=repository.save(user);
        res.setSuccess(true);
        res.setObject(userxEntity);
        return res;
    }

    @PostMapping("/user/get_statistics")
    RequestResult getUserStatistics(@RequestParam String userId){
        RequestResult res=new RequestResult();
        UserxStatistics stat=new UserxStatistics();

        stat.setPostNumber(ArticleController.repository.countByCreatorId(userId)+PostController.postRepository.countByCreatorId(userId));
        stat.setFollowNumber(MapUserUserFollowingController.repository.countByUserId0(userId));
        stat.setFollowedNumber(MapUserUserFollowingController.repository.countByUserId1(userId));

        res.setSuccess(true);
        res.setObject(stat);

        return res;
    }



}










