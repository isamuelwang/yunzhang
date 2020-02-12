package com.owwang.yunzhang.service;

import com.owwang.yunzhang.util.PrintToPdfUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Classname downloadPicByURL
 * @Description TODO
 * @Date 2020-02-08
 * @Created by WANG
 */
public class DownloadPicUtil {
    public static void main(String[] args) {
        String path1 = "D:/桌面/download/pdf/pic/";
        String path2 = "D:/桌面/download/pdf/";
        File file = new File(path1);
        File file2 = new File(path2);
        //如果路径不存在，新建
        if(!file.exists()&&!file.isDirectory()) {
            file.mkdirs();
        }
        if(!file2.exists()&&!file2.isDirectory()) {
            file2.mkdirs();
        }
        for(int i = 1;i<=200;i++){
            String url = "https://book.yunzhan365.com/mlpe/qhpr/files/mobile/"+i+".jpg";
            if(i<10){
                String s = "00"+i;
                String path = "D:/桌面/download/pdf/pic/"+s+".jpg";

                downloadPicture(url, path);
            }else if(i>=10&&i<100){
                String s2 = "0"+i;
                String path = "D:/桌面/download/pdf/pic/"+s2+".jpg";
                downloadPicture(url, path);
            }else {
                String path = "D:/桌面/download/pdf/pic/"+i+".jpg";
                downloadPicture(url, path);
            }
        }
        PrintToPdfUtil.toPdf("D:/桌面/download/pdf/pic/", "D:/桌面/download/pdf/a.pdf");
    }

    //链接url下载图片
    public static void downloadPicture(String urlList, String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
