package cn.edu.zucc.sirius.qa.controller;

import cn.edu.zucc.sirius.qa.formbean.RequestResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


@RestController
@CrossOrigin
public class FileController {

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;


    @PostMapping("/upload")
    public RequestResult upload(@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request) {
        RequestResult res = new RequestResult();
        if (file == null) {
            res.setMsg("文件不能为空");
            return res;
        }
        if (file.getSize() > 1024 * 1024 * 1) {
            res.setMsg("文件不得超过1MB");
            return res;
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"jpg,jpeg,png".toUpperCase().contains(suffix.toUpperCase())) {
            res.setMsg("请选择jpg,jpeg,png格式的图片");
            return res;
        }

        File savePathFile = new File(UPLOAD_FOLDER);

        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            if (!savePathFile.mkdir()) {
                res.setMsg("无法创建路径");
            }
        }
        //全局唯一uuid文件名
        String filename = UUID.randomUUID().toString().replaceAll("-", "") + "." + suffix;

        //保存文件
        try {
            //将文件保存指定目录
            file.transferTo(new File(UPLOAD_FOLDER + filename));
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg("发生异常: " + e.getMessage());
            return res;
        }
        res.setSuccess(true);
        res.setObject(filename);//返回文件名称
        return res;
    }

}
