package cn.edu.zucc.sirius.qa.controller;


import cn.edu.zucc.sirius.qa.entity.MapUserPlateCollectionEntity;
import cn.edu.zucc.sirius.qa.entity.MapUserUserFollowingEntity;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.MapUserPlateCollectionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MapUserPlateCollectionController {

    public static MapUserPlateCollectionRepository mapUserPlateCollectionRepository;

    public MapUserPlateCollectionController(MapUserPlateCollectionRepository mapUserPlateCollectionRepository)
    {
        MapUserPlateCollectionController.mapUserPlateCollectionRepository=mapUserPlateCollectionRepository;
    }


    //订阅
    @PostMapping("/map_user_plate_collection/subscribe")
    public RequestResult subscribe(@RequestBody MapUserPlateCollectionEntity mapUserPlateCollectionEntity)
    {
        RequestResult res=new RequestResult();

        if(mapUserPlateCollectionRepository.findByUserIdAndPlateId(mapUserPlateCollectionEntity.getUserId(),mapUserPlateCollectionEntity.getPlateId())!=null)
            mapUserPlateCollectionRepository.delete(mapUserPlateCollectionEntity);//删除/取消订阅
        else
            res.setObject(mapUserPlateCollectionRepository.save(mapUserPlateCollectionEntity));
        res.setSuccess(true);
        return res;
    }

    //列出所有订阅
    @PostMapping("/map_user_plate_collection/list")
    public RequestResult list(@RequestParam String userId)
    {
        RequestResult res=new RequestResult();
        List<MapUserPlateCollectionEntity> list= mapUserPlateCollectionRepository.findAllByUserId(userId);

        List<Integer> list_p=new ArrayList<Integer>();

        for(MapUserPlateCollectionEntity m :list)
        {
            list_p.add(m.getPlateId());
        }

        res.setObject(list_p);
        res.setSuccess(true);
        return res;
    }


}
