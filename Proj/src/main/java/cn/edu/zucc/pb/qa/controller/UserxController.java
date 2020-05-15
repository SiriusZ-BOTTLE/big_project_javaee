package cn.edu.zucc.pb.qa.controller;

import cn.edu.zucc.pb.qa.entity.UserxEntity;
import cn.edu.zucc.pb.qa.formbean.Login;
import cn.edu.zucc.pb.qa.formbean.RequestResult;
import cn.edu.zucc.pb.qa.repositories.UserxRepository;
import org.springframework.web.bind.annotation.*;

/**
 *
 */

@RestController
@CrossOrigin
public class UserxController {

    private final UserxRepository repository;

    //构造函数
    public UserxController(UserxRepository repository) {
        this.repository = repository;
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
        }
        UserxEntity userxEntity=repository.save(user);
        res.setSuccess(true);
        res.setObject(userxEntity);
        return res;
    }

}










