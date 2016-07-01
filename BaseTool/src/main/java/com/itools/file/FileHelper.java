package com.itools.file;

import com.itools.string.iStringUtils;

import java.io.*;
import java.nio.charset.Charset;

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
        try(FileOutputStream os = new FileOutputStream(file)){
            os.write(content.getBytes());
            os.flush();
        }
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
        try(FileOutputStream os = new FileOutputStream(targetFile)){
            byte[] b = new byte[128];
            int len = 0;
            while((len = sourceFileIn.read(b,0,b.length)) != -1)
                os.write(b,0,len);
            os.flush();
        }
        return targetFile;
    }

    /**
     * 根据文件路径读取文件内容，并返回内容字符串
     * @param filePath
     * @param charset
     * @return
     * @throws IOException
     */
    public static String readFile(String filePath,String charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(FileInputStream is = new FileInputStream(filePath)){
            byte[] bytes = new byte[4096];
            int len;
            while((len = is.read(bytes,0,bytes.length)) != -1){
                sb.append(iStringUtils.isEmpty(charset) ? new String(bytes,0,len)
                        : new String(bytes,0,len,charset));
            }
        }
        return sb.toString();
    }

    /**
     * 删除指定路径文件
     * @param filePath
     * @return
     */
    public static boolean deleteFile(String filePath){
        File file = new File(filePath);
        if(file.exists())
            file.delete();
        return true;
    }
}
