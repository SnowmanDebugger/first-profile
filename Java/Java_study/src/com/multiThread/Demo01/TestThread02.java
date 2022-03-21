package com.multiThread.Demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread02 extends Thread {
    private String url;  //网络图片地址
    private String name; //保存的文件名

    public TestThread02(String url,String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/1.png","1.png");
        TestThread02 t2 = new TestThread02("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/2.png","2.png");
        TestThread02 t3 = new TestThread02("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/3.png","3.png");

        t1.start();
        t2.start();
        t3.start();
    }
}


class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出问题");
        }
    }
}