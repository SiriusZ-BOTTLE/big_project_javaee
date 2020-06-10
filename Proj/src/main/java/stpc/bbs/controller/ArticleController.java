package stpc.bbs.controller;


import stpc.bbs.repositories.ArticleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ArticleController {

    public static ArticleRepository repository;

    public ArticleController(ArticleRepository repository)
    {
        ArticleController.repository=repository;
    }
}
