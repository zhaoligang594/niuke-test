package com.breakpoint.director;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaoligang.zhaolig
 * create date : 2021/08/12
 */
public class EnumFinder {

    private static final String ENUM = "enum";

    // 找到文件的第几行
    public List<Integer> findNumber(File file) {
        List<Integer> res = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str = null;
            int index = 0;
            while (null != (str = reader.readLine())) {
                index++;
                if (str.contains(ENUM)) {
                    res.add(index);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }
        return res;
    }
}
