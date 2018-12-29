package com.account.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @program: balance-of-account
 * @description: 文件工具类
 * @author: Vincent
 * @create: 2018-12-28 17:05
 **/
public class FileUtils {
    private static Logger log = LoggerFactory.getLogger("FileUtils");

    // BUFFER大小
    private static final int BUFFER = 2048;

    public static void main(String[] args) {
        System.out.println(unzipFile("D:\\logs\\1224.zip"));
    }

    /**
     * 解压文件
     *
     * @param srcFilePath
     */
    public static String unzipFile(String srcFilePath) {
        try {
            ZipFile zipFile = new ZipFile(srcFilePath, Charset.forName("GBK"));

            String zipName = srcFilePath.substring(0, srcFilePath.lastIndexOf("."));
            // 根据压缩包文件名称创建目录
            File rootFolder = new File(zipName);
            rootFolder.deleteOnExit();
            rootFolder.mkdirs();

            int count = 0;
            Enumeration enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();

                // 压缩像为目录，创建
                if (zipEntry.isDirectory()) {
                    new File(zipName + "/" + zipEntry.getName()).mkdirs();
                    continue;
                }

                // 获取压缩项流
                BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(zipEntry));

                // 生成压缩项文件，如果父目录不存在，则创建
                File file = new File(zipName + "/" + zipEntry.getName());
                File parent = file.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }

                // 输出文件
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file), BUFFER);
                byte[] data = new byte[BUFFER];
                while ((bis.read(data, 0, BUFFER)) != -1) {
                    bos.write(data, 0, BUFFER);
                }

                // 关闭流
                bos.flush();
                bos.close();
                bis.close();
                count++;
            }
            log.info("解压文件[" + srcFilePath + "], 子文件个数=" + count);
            return zipName;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("解压文件, 异常=" + e.getMessage());
        }
        return "";
    }

}
