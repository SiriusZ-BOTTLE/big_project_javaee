package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.entity.MapUserPlateCollectionEntity;
import cn.edu.zucc.sirius.qa.entity.MapUserPostCollectionEntity;
import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import cn.edu.zucc.sirius.qa.repositories.MapUserPostCollectionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MapUserPostCollectionController {

    public static MapUserPostCollectionRepository mapUserPostCollectionRepository;

    //构造函数初始化repository
    public MapUserPostCollectionController(MapUserPostCollectionRepository mapUserPostCollectionRepository){
        MapUserPostCollectionController.mapUserPostCollectionRepository=mapUserPostCollectionRepository;
    }


    //收藏/取消收藏
    @PostMapping("/map_user_post_collection/collect")
    public RequestResult subscribe(@RequestBody MapUserPostCollectionEntity mapUserPostCollectionEntity)
    {
        RequestResult res=new RequestResult();

        if(mapUserPostCollectionRepository.findByUserIdAndPostId(mapUserPostCollectionEntity.getUserId(),mapUserPostCollectionEntity.getPostId())!=null)
            mapUserPostCollectionRepository.delete(mapUserPostCollectionEntity);//删除/取消订阅
        else
            res.setObject(mapUserPostCollectionRepository.save(mapUserPostCollectionEntity));
        res.setSuccess(true);
        return res;
    }

    //列出所有收藏ID号
    @PostMapping("/map_user_post_collection/list")
    public RequestResult list(@RequestParam String userId)
    {
        RequestResult res=new RequestResult();
        List<MapUserPostCollectionEntity> list= mapUserPostCollectionRepository.findAllByUserId(userId);

        List<Integer> list_p=new ArrayList<Integer>();

        for(MapUserPostCollectionEntity m :list)
        {
            list_p.add(m.getPostId());
        }

        res.setObject(list_p);
        res.setSuccess(true);
        return res;
    }


}
