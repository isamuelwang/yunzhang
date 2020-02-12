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
        String filename = downloadService.download(pdfFile);
        String fileUrl = "http://cos.owwang.com/"+filename;
        return new QiNiuResult(true,fileUrl);
    }
}
