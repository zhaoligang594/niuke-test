package com.breakpoint;

import com.sun.istack.internal.NotNull;
import com.sun.tools.javac.util.Assert;

/**
 * Hello world!
 */
public class App {
     public static void main(String[] args) {

         aaaa(null);
         System.out.println(Math.exp(10.0));
    }

    @NotNull public static boolean aaaa(Object obj) {
        Assert.checkNull(obj,null);
        return false;
    }
}
