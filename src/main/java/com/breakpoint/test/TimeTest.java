package com.breakpoint.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-04-18
 */
public class TimeTest {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
    }
}
