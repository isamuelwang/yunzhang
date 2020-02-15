package com.owwang.yunzhang.service;


import com.owwang.yunzhang.dao.BookDao;
import com.owwang.yunzhang.pojo.Book;
import com.owwang.yunzhang.pojo.PdfFile;
import com.owwang.yunzhang.util.DownloadPicUtil;
import com.owwang.yunzhang.util.PrintToPdfUtil;
import com.owwang.yunzhang.util.QiNiuResult;
import com.owwang.yunzhang.util.QiNiuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

/**
 * @Classname DownloadService
 * @Description TODO
 * @Date 2020-02-13
 * @Created by WANG
 */
@Service
@Slf4j
public class DownloadService {
    @Autowired
    private BookDao bookDao;

    public void testSql(){
        bookDao.insert(new Book("1",5,"3","4","5","6"));
    }

    //下载云展网资源
    public String download(PdfFile pdfFile) {
        String bookUrl = pdfFile.getBookUrl();
        int pageTotal = pdfFile.getPageTotal();
        String fileName = UUID.randomUUID().toString().replaceAll("-","");
        //pdf地址
        String pdfPath = "/yunzhang/" + fileName + "/pdf/";
        //图片地址
        String picPath = "/yunzhang/" + fileName + "/pic/";
        String imgUrl = generateImgUrl(bookUrl);
        checkPath(pdfPath, picPath);
        overDownload(pageTotal, imgUrl, picPath, fileName);
        //生成pdf
        PrintToPdfUtil.toPdf(picPath, pdfPath + fileName + ".pdf",pageTotal);
        //上传到七牛云
        QiNiuResult result = QiNiuUtil.upload("picbed8", new File(pdfPath + fileName + ".pdf"));
        //删除临时文件
        delFile(new File("/yunzhang/" + fileName));
        if (!result.isError()) {
            return "false";
        } else {
            return result.getUrl();
        }
    }



    //下载读秀网资源
    public String download2(PdfFile pdfFile) {
        String bookUrl = pdfFile.getBookUrl();
        int pageTotal = pdfFile.getPageTotal();
        String fileName = UUID.randomUUID().toString().replaceAll("-","");
        //pdf地址
        String pdfPath = "/yunzhang/" + fileName + "/pdf/";
        //图片地址
        String picPath = "/yunzhang/" + fileName + "/pic/";
        String imgUrl = generateImgUrl(bookUrl);
        checkPath(pdfPath, picPath);
        overDownload(pageTotal, imgUrl, picPath, fileName);
        //生成pdf
        PrintToPdfUtil.toPdf(picPath, pdfPath + fileName + ".pdf",pageTotal);
        //上传到七牛云
        QiNiuResult result = QiNiuUtil.upload("picbed8", new File(pdfPath + fileName + ".pdf"));
        //删除临时文件
        delFile(new File("/yunzhang/" + fileName));
        if (!result.isError()) {
            return "false";
        } else {
            return result.getUrl();
        }
    }

    private boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
        }
        return file.delete();
    }

    //遍历循环下载资源(带总页数参数）
    private void overDownload(int pageTotal, String imgUrl, String picPath, String fileName) {
        for (int i = 1; i <= pageTotal; i++) {
            log.info("正在下载地址书本每页图片：" + imgUrl + i + ".jpg");
            DownloadPicUtil.downloadPicture(imgUrl + i + ".jpg", picPath + i + ".jpg");
        }
    }

    //根据书本链接生成云展网图片链接
    private String generateImgUrl(String bookUrl) {
        //图片地址
        String imgUrl = null;
        int index = bookUrl.indexOf("/mobile");
        imgUrl = bookUrl.substring(0, index);
        return imgUrl + "/files/mobile/";
    }

    //根据书本链接生成读秀网图片链接
    private String generateImgUrl2(String bookUrl) {
        //图片地址
        String imgUrl = null;
        int index = bookUrl.indexOf("/mobile");
        imgUrl = bookUrl.substring(0, index);
        return imgUrl + "/files/mobile/";
    }

    //检查系统中是否存在目标下载文件夹
    private void checkPath(String picPath, String pdfPath) {

        File file = new File(picPath);
        File file2 = new File(pdfPath);
        //如果路径不存在，新建
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
            log.info(file.getName() + "文件夹创建成功");
        }
        if (!file2.exists() && !file2.isDirectory()) {
            file2.mkdirs();
            log.info(file2.getName() + "文件夹创建成功");
        }
    }
}
