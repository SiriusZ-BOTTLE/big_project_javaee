package cn.edu.zucc.sirius.qa.controller;


import cn.edu.zucc.sirius.qa.entity.MapUserPlateCollectionEntity;
import cn.edu.zucc.sirius.qa.entity.MapUserUserFollowingEntity;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.MapUserPlateCollectionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        res.setObject(mapUserPlateCollectionRepository.save(mapUserPlateCollectionEntity));
        res.setSuccess(true);
        return res;
    }


}
