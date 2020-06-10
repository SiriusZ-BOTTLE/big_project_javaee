package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.entity.PlateEntity;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.PlateRepository;
import org.springframework.web.bind.annotation.*;

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
    public RequestResult list()
    {
        RequestResult res=new RequestResult();
        Byte one=new Byte("1");
        res.setObject(plateRepository.findAllByActivated(one));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/plate/list_user_collection")
    public RequestResult list_user_collection(@RequestParam String userId)
    {
        RequestResult res=new RequestResult();

//        MapUserPlateCollectionController.mapUserPlateCollectionRepository.find

        res.setObject(plateRepository.findUserSubscription(userId));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/plate/get")
    public RequestResult get(@RequestParam Integer plateId)
    {
        RequestResult res=new RequestResult();
        res.setObject(plateRepository.findByPlateId(plateId));
        res.setSuccess(true);
        return res;
    }
}
