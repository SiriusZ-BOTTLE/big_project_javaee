package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.entity.PlateEntity;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.PlateRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PlateController {

    public static PlateRepository plateRepository;


    public PlateController(PlateRepository plateRepository){
        PlateController.plateRepository=plateRepository;
    }

    /**
     * 创建板块
     * @param plateEntity 对象
     * @return RequestResult
     */
    @PostMapping("/plate/create")
    public RequestResult create(@RequestBody PlateEntity plateEntity)
    {
        RequestResult res=new RequestResult();
        res.setObject(plateRepository.save(plateEntity));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/plate/list")
    public RequestResult create()
    {
        RequestResult res=new RequestResult();
        Byte one=new Byte("1");
        res.setObject(plateRepository.findAllByActivated(one));
        res.setSuccess(true);
        return res;
    }

}
