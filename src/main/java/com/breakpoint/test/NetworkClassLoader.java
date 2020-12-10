package com.breakpoint.test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/08/22
 */
public class NetworkClassLoader extends ClassLoader {

    private String filePath;

    public NetworkClassLoader(String filePath) {
        this.filePath = filePath;
    }
    // 连接网络，进行操作
    private byte[] loadClassData(String name) throws ClassNotFoundException {
        try {
            URL url = new URL(filePath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();
            byte[] bytes = readInputStream(inStream);//得到图片的二进制数据
            return bytes;
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }
}
