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

    /**
     * 将文件输入流流出到指定的文件
     * @param sourceFileIn 文件流
     * @param targetFilePath 目标文件地址
     * @param targetFileName 目标文件名称
     * @throws IOException
     */
    public static File copyFile(InputStream sourceFileIn,String targetFilePath,String targetFileName) throws IOException {
        File targetFile = new File(targetFilePath,targetFileName);
        if(!targetFile.exists())
            targetFile.createNewFile();
        FileOutputStream os = new FileOutputStream(targetFile);
        byte[] b = new byte[128];
        int len = 0;
        while((len = sourceFileIn.read(b,0,b.length)) != -1)
            os.write(b,0,len);
        os.flush();
        os.close();
        return targetFile;
    }
}
