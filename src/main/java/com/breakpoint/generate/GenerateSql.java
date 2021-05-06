package com.breakpoint.generate;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-03-21
 */
public class GenerateSql {

    public static void main(String[] args) {
        String pattern = "alter table `kwaishop_livestream_reservation_%d` add column `photo_audit_result` " +
                "JSON comment \"短视频预告的审核结果\"; ";
//        String pattern = "alter table `kwaishop_livestream_reservation_%d` modify column `photo_audit_result` " +
//                "JSON; ";
        for (int i = 0; i < 100; i++) {
            System.out.println(String.format(pattern, i));
        }
    }
}
