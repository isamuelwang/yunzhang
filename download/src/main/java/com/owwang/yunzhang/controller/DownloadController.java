package com.owwang.yunzhang.controller;

import com.owwang.yunzhang.pojo.PdfFile;
import com.owwang.yunzhang.service.DownloadService;
import com.owwang.yunzhang.util.QiNiuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname DownloadController
 * @Description TODO
 * @Date 2020-02-13
 * @Created by WANG
 */
@CrossOrigin
@RestController
public class DownloadController {
    @Autowired
    DownloadService downloadService;

    @PostMapping(value = "/download")
    @ResponseBody
    public QiNiuResult download(@RequestBody PdfFile pdfFile){
        //查询数据库，如果数据库存在数据，则返回数据库中信息即可

        if(pdfFile.getBookUrl().contains("https://book.yunzhan365.com/")){
            String filename = downloadService.download(pdfFile);
            String fileUrl = "http://cos.owwang.com/"+filename;
            return new QiNiuResult(true,fileUrl);
        }else if(pdfFile.getBookUrl().contains("http://npng1.5read.com/")){
               return null;
        } else {
            return new QiNiuResult(false,"请输入正确的链接地址");
        }
    }

    @GetMapping("/test")
    public void testSql(){
        downloadService.testSql();
    }
}
