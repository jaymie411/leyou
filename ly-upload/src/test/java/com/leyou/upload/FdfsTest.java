package com.leyou.upload;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/28
 * @time: 23:56
 * @description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FdfsTest {

    @Autowired
    private static FastFileStorageClient storageClient;

    @Autowired(required = false)
    private static ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("D:/test/baby.png");
        FileInputStream inputStream = new FileInputStream(file);
        //上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadFile(
                inputStream, file.length(), "png", null);

        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException {
        File file = new File("D:\\test\\baby.png");
        //上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "png", null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
    }
}
