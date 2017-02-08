package com.example.lzc.workframedemo.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 类描述：文件保存
 * 创建人：zz
 * 创建时间：2016/11/24 17:32
 */
public class FileUtils {

    /**
     * 保存字符串到本地
     */
    public static void saveStringToLocal(String res){
        try {
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                File sdCardDir = Environment.getExternalStorageDirectory();//获取SDCard目录
                File sdFile = new File(sdCardDir, "res.txt");
                if(!sdFile.exists()){
                    sdFile.createNewFile();
                }

                try {
                    FileOutputStream fos = new FileOutputStream(sdFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(res);// 写入
                    fos.close(); // 关闭输出流
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){}
    }
}
