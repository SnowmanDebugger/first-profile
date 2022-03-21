package com.multiThread.Demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable <Boolean> {
    private String url;  //网络图片地址
    private String name; //保存的文件名

    public TestCallable(String url,String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/1.png","1.png");
        TestCallable t2 = new TestCallable("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/2.png","2.png");
        TestCallable t3 = new TestCallable("https://yzhchen-images-1309939343.cos.ap-shanghai.myqcloud.com/test-image/3.png","3.png");

        //创建执行服务：(通过服务来提交线程）
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();

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