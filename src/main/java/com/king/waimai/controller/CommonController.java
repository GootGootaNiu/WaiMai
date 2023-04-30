package com.king.waimai.controller;

import com.king.waimai.common.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Classname CommonController
 * @Description ***
 * @Date 2023/3/19 21:09
 * @Author wyf
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;
    /**
     * 文件上上传
     */
    @PostMapping("/upload")
    public R<String > upload(MultipartFile file) throws FileNotFoundException {
        String contentType = file.getContentType();
        System.out.println(contentType+"----------");
        if ("image/jpeg".equals(contentType)||"iamge/jpg".equals(contentType)){

        String originalFilename = file.getOriginalFilename();
        String  suffix =originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+suffix;
       File tempFile=  new File(basePath);
       if (!tempFile.exists()){
           tempFile.mkdirs();
       }
        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return R.success(fileName);
        }else {
            return R.error("文件类型不支持");
        }
    }
    /**
     * 下载文件
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        FileInputStream fs=null;
        ServletOutputStream outputStream=null;
        try {
            response.setContentType("image/jpeg");
            fs = new FileInputStream(basePath+name);
             outputStream = response.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
//            直接写流给浏览器，让浏览器读取
            while((len = fs.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
//                outputStream.flush();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (fs!=null)
                fs.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (outputStream!=null)
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
