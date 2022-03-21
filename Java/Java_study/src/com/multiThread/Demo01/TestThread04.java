package com.multiThread.Demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread04 implements Runnable {
    private String url;  //网络图片地址
    private String name; //保存的文件名

    public TestThread04(String url,String name) {
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
        TestThread04 t1 = new TestThread04("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/1.png","1.png");
        TestThread04 t2 = new TestThread04("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/2.png","2.png");
        TestThread04 t3 = new TestThread04("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/3.png","3.png");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}


