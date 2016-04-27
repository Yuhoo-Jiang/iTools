package com.itools.file;

import java.io.*;

/**
 * 作者：蒋祖兵
 * 描述：
 * 时间： 2016/4/27.
 */
public class FileHelper {
    /**
     * 创建一个新文件，并且将String串写入文件
     * @param path 文件路径
     * @param fileName 文件名
     * @param content
     * @throws IOException
     */
    public static void createFile(String path,String fileName,String content) throws IOException {
        File file = new File(path + "/" + fileName);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream os = new FileOutputStream(file);
        os.write(content.getBytes());
        os.flush();
        os.close();
    }

}
