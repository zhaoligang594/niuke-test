package com.breakpoint.school;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-03-07
 */
public class GenerateService {

    private static Map<String, Integer> bandWidth = new HashMap<>();

    static String[] names = {"XX-YT-01 ", "XX-YT-02 ", "XX-YT-03 ", "YY-YT-04 ", "YY-YT-05 ", "YY-YT-06 ", "A01-YT-01"
            , "A01-YT-02", "A02-YT-03", "A02-YT-04", "A02-YT-05", "A03-YT-06", "A03-YT-07", "B01-YT-01", "B01-YT-02",
            "B02-YT-03", "B03-YT-04", "B03-YT-05", "B04-YT-06", "B04-YT-07", "B05-YT-08", "B06-YT-09", "B06-YT-10"};

    static Double[] band = {8.0, 10.0, 6.0, 8.0, 10.0, 6.0, 0.1, 0.2, 0.1, 0.1, 0.2, 0.1, 0.2, 0.05, 0.1, 0.1, 0.05, 0.1
            , 0.05, 0.1, 0.1, 0.05, 0.1};

    private static Map<String, String> paths = new HashMap<>();

    static {
        for (int i = 0; i < names.length; i++) {
            bandWidth.put(names[i].trim(), (int) (band[i] * 1000));
        }
        // 规划后的路由情况
        paths.put("XX-YT-02", "N2-L01-S;J-02-S;N1-L05-S;");
        paths.put("XX-YT-03", "N2-L01-S;J-02-S;N1-L05-S;");
        paths.put("YY-YT-04", "N3-L04-S;J-03-S;N1-L05-S;N3-L01-S;J-04-S;N1-L04-S;");
        paths.put("YY-YT-05", "N3-L04-S;J-03-S;N1-L05-S;");
        paths.put("YY-YT-06", "N3-L04-S;J-03-S;N1-L05-S;");
        paths.put("A01-YT-01", "N1-L02-S;N1-L01-S;N1-L04-S;N1-L03-S;");
        paths.put("A01-YT-02", "N1-L01-S;");
        paths.put("A02-YT-03", "N1-L02-S;N1-L03-S;N1-L04-S;N1-L01-S;");
        paths.put("A02-YT-04", "N1-L03-S;N1-L05-S;N1-L04-S;");
        paths.put("A02-YT-05", "N1-L05-S;");
        paths.put("A03-YT-06", "N1-L03-S;N1-L04-S;N1-L05-S;");
        paths.put("A03-YT-07", "N1-L04-S;");
        paths.put("B01-YT-01", "J-02-S;N2-L01-S;N2-L04-W;J-01-S;N1-L02-S;");
        paths.put("B01-YT-02", "N2-L01-S;");
        paths.put("B02-YT-03", "N2-L02-S;N2-L01-S;");
        paths.put("B03-YT-04", "J-01-S;N2-L04-W;N2-L01-S;J-02-S;N1-L02-S;");
        paths.put("B03-YT-05", "N2-L04-W;");
        paths.put("B04-YT-06", "J-04-S;N3-L01-S;N3-L04-S;J-03-S;N1-L03-S;");
        paths.put("B04-YT-07", "N3-L01-S;");
        paths.put("B05-YT-08", "N3-L03-S;N3-L04-S;");
        paths.put("B06-YT-09", "J-03-S;N3-L04-S;N3-L01-S;J-04-S;N1-L03-S;");
        paths.put("B06-YT-10", "N3-L04-S;");

    }



    public static void main(String[] args) {
        final Map<String, Integer> result = new HashMap<>();
        paths.forEach(((serviceId, path) -> {
            String[] split = path.split(";");
            if (split != null && split.length > 0) {
                for (String p : split) {
                    if (null != p && !"".equals(p)) {
                        String key = p.substring(0, p.length() - 2);
                        Integer integer = bandWidth.get(serviceId.trim());
                        result.put(key, result.getOrDefault(key, 0) + integer);
                    }
                }
            }
        }));

        //
        result.forEach(((key, band) -> {
            System.out.println(key);
            System.out.println(band);
        }));
    }
}
