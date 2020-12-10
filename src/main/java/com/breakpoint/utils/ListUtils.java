package com.breakpoint.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author breakpoint/zlg
 * 2020/08/31
 */
public abstract class ListUtils {

    public static List<Integer> getListByString(String data) {
        //data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(!"".equals(split[i])){
                list.add(Integer.valueOf(split[i]));
            }
        }
        return list;
    }


    public static List<List<Integer>> getList2(String data){
        data = data.substring(2, data.length() - 2);
        String[] split = data.split("],\\[");
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < split.length; i++) {
            list.add(getListByString(split[i]));
        }
        return list;
    }

}
