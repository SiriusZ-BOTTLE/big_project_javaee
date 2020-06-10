package stpc.bbs.controller;


import stpc.bbs.entity.ImageEntity;
import stpc.bbs.formbean.ImagesListRequest;
import stpc.bbs.formbean.RequestResult;
import stpc.bbs.repositories.ImageRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ImageController {

    public static ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository){
        ImageController.imageRepository=imageRepository;
    }

    @PostMapping("/image/create")
    public RequestResult create(@RequestBody ImageEntity imageEntity)
    {
        RequestResult res=new RequestResult();

        res.setObject(imageRepository.save(imageEntity));
        res.setSuccess(true);
        return res;
    }

    @PostMapping("/image/list")
    public RequestResult list(@RequestBody ImagesListRequest imagesListRequest){
        RequestResult res=new RequestResult();

        res.setObject(imageRepository.findAllByObjectIdAndImageType(imagesListRequest.getObjectId(),imagesListRequest.getImageType()));
        res.setSuccess(true);
        return res;
    }


}
