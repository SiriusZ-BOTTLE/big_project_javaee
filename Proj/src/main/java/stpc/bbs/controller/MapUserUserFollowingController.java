package stpc.bbs.controller;


import stpc.bbs.repositories.MapUserUserFollowingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MapUserUserFollowingController {
    public static MapUserUserFollowingRepository repository;

    public MapUserUserFollowingController(MapUserUserFollowingRepository repository)
    {
        MapUserUserFollowingController.repository=repository;
    }


}
