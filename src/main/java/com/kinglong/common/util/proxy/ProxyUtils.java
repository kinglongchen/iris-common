package com.kinglong.common.util.proxy;

import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by chenjinlong on 17/1/4.
 */
@Slf4j
public class ProxyUtils {
    /**
     * 将根据类信息动态生成的二进制字节码保存到硬盘中，默认的是clazz目录下
     * @param clazz 需要生成动态代理类的类
     * @param proxyName 为动态生成的代理类的名称
     */
    public static void generateClassFile(Class clazz,String proxyName) {
        generateClassFile(clazz,proxyName,null);
    }

    public static void generateClassFile(Class clazz,String proxyName,String paths) {

        if (paths == null) {
            paths = clazz.getResource("/").getPath();
        }
        if (!String.valueOf(paths.charAt(paths.length()-1)).equals(File.separator)) {
            paths += File.separator;
        }
        //根据类信息和提供的代理类名称，生成字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        log.info("动态生成的二进制字节码保存到硬盘中的Path:"+paths);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(paths + proxyName +".class"));
            out.write(classFile);
        } catch (FileNotFoundException e) {
            log.error("保存二进制字节码出错！",e);
        } catch (IOException e) {
            log.error("保存二进制字节码出错！",e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                log.error("关闭文件流出错！",e);
            }
        }
    }
}
